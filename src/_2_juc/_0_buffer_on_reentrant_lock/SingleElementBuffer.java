package _2_juc._0_buffer_on_reentrant_lock;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SingleElementBuffer {
    private final Lock lock = new ReentrantLock(true); // fairness
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();
    private Integer elem = null;

    public void put(int newElem) throws InterruptedException {
        try {
            lock.lock();
            while (this.elem != null) {
                notFull.await(); // await not wait
            }
            this.elem = newElem;
            notEmpty.signal(); // signal not signalAll
        } finally {
            lock.unlock();
        }
    }

    public boolean tryPut(int newElem) throws InterruptedException {
        if (lock.tryLock()) {
            put(newElem);
            return true;
        } else {
            return false;
        }
    }

    public boolean tryPut(int newElem, long timeout, TimeUnit units) throws InterruptedException {
        if (lock.tryLock(timeout, units)) {
            put(newElem);
            return true;
        } else {
            return false;
        }
    }

    public int get() throws InterruptedException {
        lock.lock();
        try {
            while (elem == null) {
                notEmpty.await();
            }
            Integer result = elem;
            elem = null;
            notFull.signal();
            return result;
        } finally {
            lock.unlock();
        }

    }
}

class Test {
    public static void main(String[] args) {
        Method[] declaredMethodsFile = File.class.getDeclaredMethods();
        System.out.println(declaredMethodsFile.length);
        Method[] declaredMethods = AbstractQueuedSynchronizer.class.getDeclaredMethods();
        System.out.println(declaredMethods.length);
    }
}
