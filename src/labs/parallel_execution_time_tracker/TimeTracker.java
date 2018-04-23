package labs.parallel_execution_time_tracker;

import java.util.Random;
import java.util.concurrent.*;

public class TimeTracker {
    private long trackTime(ExecutorService executor, int concurrency, final Runnable action) throws InterruptedException {
        final CountDownLatch ready = new CountDownLatch(concurrency);
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch done = new CountDownLatch(concurrency);
        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                ready.countDown();
                try {
                    start.await();
                    action.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    done.countDown();
                }
            });
        }
        ready.await();
        System.out.println("All threads ready. Starting...");
        long startTime = System.nanoTime();
        start.countDown();
        done.await();
        long endTime = System.nanoTime();
        System.out.println("All threads have finished");
        executor.shutdown();
        return endTime - startTime;
    }

    private void sillyWork() {
        try {
            long workingTime = new Random().nextInt(10_000);
            System.out.println(Thread.currentThread().getName() + " start for " + workingTime + " milliseconds");
            Thread.sleep(workingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " finished");
    }

    public static void main(String[] args) throws InterruptedException {
        TimeTracker timeTracker = new TimeTracker();
        long spentTime = timeTracker.trackTime(Executors.newFixedThreadPool(5), 5, timeTracker::sillyWork);
        System.out.println("Time spent: " + (spentTime / 1_000_000) + " milliseconds");
    }
}
