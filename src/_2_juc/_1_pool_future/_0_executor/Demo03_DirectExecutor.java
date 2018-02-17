package _2_juc._1_pool_future._0_executor;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

public class Demo03_DirectExecutor {
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
                command.run();
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
