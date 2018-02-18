package veres_labs.lab3a;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static int pot = 0;
    static int capacity = 10;
    static int beesAmount = 10;
    static final Lock lock = new ReentrantLock();
    static final Condition bear = lock.newCondition();
    static final Condition bees = lock.newCondition();

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
        for (int k = 0; k < beesAmount; k++) {
            new Thread(new Bee()).start();
        }
    }
}
