package _2_juc._1_pool_future._0_executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo06_Executors {
    public static void main(String[] args) {
//        Executor executor = Executors.newSingleThreadExecutor();
//        Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(getTask());
        executor.execute(getTask());
        executor.execute(getTask());

        executor.shutdown();

        while (!executor.isTerminated()) {
        }

    }

    private static Runnable getTask() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from thread " + Thread.currentThread());
            }
        };
    }
}
