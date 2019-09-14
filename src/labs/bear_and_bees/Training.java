package labs.bear_and_bees;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Training {

    private static final int CAPACITY = 10;
    private static final Lock lock = new ReentrantLock();
    private static final Condition bear = lock.newCondition();
    private static final Condition bees = lock.newCondition();
    private static int pot;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(11);


        Runnable beeTask = () -> {
            while (true) {
                try {
                    lock.lock();
                    while (pot == CAPACITY) {
                        bees.await();
                    }
                    pot++;
                    System.out.println("Bee put honey into pot. Portions amount = " + pot);
                    bear.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Runnable bearTask = () -> {
            while (true) {
                try {
                    lock.lock();
                    while (pot != CAPACITY) {
                        bear.await();
                    }
                    pot = 0;
                    System.out.println("Bear woke up and in the honey. Portions amount = " + pot);
                    bees.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            executor.execute(beeTask);
        }
        executor.execute(bearTask);
    }
}
