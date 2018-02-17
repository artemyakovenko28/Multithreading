package _2_juc._1_pool_future._0_executor;

import java.util.concurrent.Executor;

public class Demo01 {
    public static void main(String[] args) {
        // two tasks on Executor 1
        Executor firstExecutor = getExecutor();
        firstExecutor.execute(getTask());
        firstExecutor.execute(getTask());

        // three tasks on Executor 2
        Executor secondExecutor = getExecutor();
        secondExecutor.execute(getTask());
        secondExecutor.execute(getTask());
        secondExecutor.execute(getTask());
    }

    private static Executor getExecutor() {
        throw new UnsupportedOperationException();
    }

    private static Runnable getTask() {
        throw new UnsupportedOperationException();
    }
}
