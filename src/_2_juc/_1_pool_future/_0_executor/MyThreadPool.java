package _2_juc._1_pool_future._0_executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

public class MyThreadPool implements Executor {
    private final BlockingQueue<Runnable> taskQueue = new ArrayBlockingQueue<Runnable>(1);
    private final Thread[] pool;

    public MyThreadPool(int threadCount) {
        this.pool = new Thread[threadCount];
        for (int k = 0; k < pool.length; k++) {
            pool[k] = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            // block
                            Runnable nextTask = taskQueue.take();
                            nextTask.run();
                        } catch (InterruptedException e) {
                            break;
                        }
                    }
                }
            });
            pool[k].start();
        }
    }

    @Override
    public void execute(Runnable command) {
        //OFFER demo
        if (!taskQueue.offer(command)) {
            System.out.println("Rejected!");
        }
//        // PUT demo
//        try {
//            // if full - not reject, but block
//            taskQueue.put(command);
//        } catch (InterruptedException e) {
//            throw new Error("NEVER!", e);
//        }
//
//        //ADD demo
//        try {
//            taskQueue.add(command);
//        } catch (IllegalStateException e) {
//            System.out.println("Rejected!");
//        }
    }
}
