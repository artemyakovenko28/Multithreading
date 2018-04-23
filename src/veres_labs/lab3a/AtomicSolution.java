package veres_labs.lab3a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicSolution {
    private static final int BEES_AMOUNT = 10;
    private static final int CAPACITY = 10;
    private static AtomicInteger pot = new AtomicInteger(0);
    private static volatile int notSafePot = 0;

    private void go(ExecutorService executor) {
        Runnable bee = () -> {
            while (true) {
                while (true) {
                    int oldValue = pot.get();
                    if (oldValue < CAPACITY) {
                        int newValue = oldValue + 1;
                        if (pot.compareAndSet(oldValue, newValue)) {
                            System.out.println("Bee put honey into pot. Portions amount = " + newValue);
                            break;
                        }
                    }
                }
            }
        };

        Runnable bear = () -> {
            while (true) {
                if (pot.compareAndSet(CAPACITY, 0)) {
                    System.out.println("Bear woke up and eat the honey");
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < BEES_AMOUNT; i++) {
            executor.execute(bee);
        }
        executor.execute(bear);
    }

    public static void main(String[] args) throws InterruptedException {
        new AtomicSolution().go(Executors.newFixedThreadPool(BEES_AMOUNT + 1));
    }
}
