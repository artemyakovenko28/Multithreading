package labs.simple_executor_service;

import java.util.concurrent.ArrayBlockingQueue;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        SimpleExecutorService pool = new SimpleExecutorService(5, new ArrayBlockingQueue<>(10));
        for (int i = 0; i < 10; i++) {
            pool.submit(() -> System.out.println(Thread.currentThread().getName()));
        }

        Thread.sleep(3000);
        pool.shutdownNow();
    }
}
