package _2_juc._1_pool_future._0_executor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo05_ThreadPoolExecutor {
    public static void main(String[] args) {
        int corePoolSize = 4;
        int maximumPoolSize = 64;
        long keepAliveTime = 10;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(256);
        ThreadFactory threadFactory = new ThreadFactory() {
            private AtomicInteger counter = new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setPriority(Thread.NORM_PRIORITY);
                thread.setName("MyPool-NORM_PRIORITY-" + counter.incrementAndGet());
                return thread;
            }
        };
        RejectedExecutionHandler handler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("All threads are busy + task queue is full");
            }
        };

        Executor myThreadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                keepAliveTime, timeUnit, workQueue, threadFactory, handler);

        myThreadPoolExecutor.execute(getTask());
        myThreadPoolExecutor.execute(getTask());
        myThreadPoolExecutor.execute(getTask());
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
