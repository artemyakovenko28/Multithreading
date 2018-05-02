package labs.bear_and_bees;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSolution {
    private static int pot = 0;
    private static int capacity = 10;
    private static final int BEES_AMOUNT = 10;
    private static final Lock lock = new ReentrantLock();
    private static final Condition bear = lock.newCondition();
    private static final Condition bees = lock.newCondition();

    static class Bee implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    while (pot == capacity) {
                        bees.await();
                    }
                    pot++;
                    System.out.println("Bee puts honey");
                    if (pot == capacity) {
                        System.out.println("Bee woke up the bear");
                        bear.signal();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Bear implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    while (pot != capacity) {
                        bear.await();
                    }
                    pot = 0;
                    System.out.println("Bear woke up and ate the honey");
                    bees.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Bear()).start();
        for (int k = 0; k < BEES_AMOUNT; k++) {
            new Thread(new Bee()).start();
        }
    }
}
