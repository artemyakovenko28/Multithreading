package labs.simple_executor_service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

public class SimpleExecutorService {

    private final BlockingQueue<Runnable> taskQueue;
    private final Collection<Thread> workers = new ArrayList<>();

    public SimpleExecutorService(int threadsCount, BlockingQueue<Runnable> taskQueue) {
        this.taskQueue = taskQueue;
        for (int i = 0; i < threadsCount; i++) {
            Thread worker = new Thread(() -> {
                while (true) {
                    try {
                        Runnable nextTask = taskQueue.take();
                        nextTask.run();
                    } catch (InterruptedException e) {
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            workers.add(worker);
            worker.start();
        }
    }

    public void submit(Runnable task) throws InterruptedException {
        taskQueue.put(task);
    }

    public void shutdownNow() {
        workers.forEach(Thread::interrupt);
    }
}
