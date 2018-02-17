package _2_juc._1_pool_future._0_executor;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

public class Demo02_ThreadPerTaskExecutor {
    public static void main(String[] args) {
        Executor executor = getExecutor();
        executor.execute(getTask());
        executor.execute(getTask());

        System.out.println("Hello from " + Thread.currentThread());
    }

    private static Executor getExecutor() {
        return new Executor() {
            private final AtomicLong index = new AtomicLong(0);
            private final ThreadGroup group = new ThreadGroup("MyGroup");

            @Override
            public void execute(Runnable command) {
                Thread thread = new Thread(group, command);
                thread.setName("Thread-#" + index.getAndIncrement());
                thread.setPriority(Thread.NORM_PRIORITY + 1);
//                thread.setDaemon(true);
                thread.start();
            }
        };
    }

    private static Runnable getTask() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from " + Thread.currentThread());
            }
        };
    }
}
