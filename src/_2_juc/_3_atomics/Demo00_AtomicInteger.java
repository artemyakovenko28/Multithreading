package _2_juc._3_atomics;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo00_AtomicInteger {
    private static AtomicInteger index = new AtomicInteger(0);

    private static int getAndIncrement(AtomicInteger value) {
        for(;;) {
            int current = value.get();
            int next = current + 1;
            if (value.compareAndSet(current, next)) {
                return current;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread firstThread = new Thread(() -> {
            for (int k = 0; k < 10_000; k++) {
//                index.getAndIncrement();
                getAndIncrement(index);
            }
        });
        firstThread.start();

        Thread secondThread = new Thread(() -> {
            for (int k = 0; k < 10_000; k++) {
//                index.getAndIncrement();
                getAndIncrement(index);
            }
        });
        secondThread.start();

        firstThread.join();
        secondThread.join();
        System.out.println(index);
    }
}
