package _2_juc._0_read_write_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SimpleRWUsage {
    public static void main(String[] args) {
        ReadWriteLock rwLock = new ReentrantReadWriteLock();
        final Lock rLock = rwLock.readLock();
        final Lock wLock = rwLock.writeLock();

        new Thread(new Runnable() {  // W
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                wLock.lock();
                System.out.println("2");
                while (true) ;
            }
        }).start();

        new Thread(new Runnable() {  // R
            @Override
            public void run() {
                rLock.lock();
                System.out.println("0");
                while (true) ;
            }
        }).start();

        new Thread(new Runnable() {  // R
            @Override
            public void run() {
                rLock.lock();
                System.out.println("1");
                while (true) ;
            }
        }).start();
    }
}
