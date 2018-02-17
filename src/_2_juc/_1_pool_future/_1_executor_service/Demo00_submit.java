package _2_juc._1_pool_future._1_executor_service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Demo00_submit {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService execService = Executors.newCachedThreadPool();

        Callable<Integer> task0 = new Callable<>() {
            @Override
            public Integer call() {
                return 42;
            }
        };
        Future<Integer> future0 = execService.submit(task0);

        Callable<Integer> task1 = new Callable<>() {
            @Override
            public Integer call() {
                while (true) { /* infinity loop */
                    if (Thread.interrupted()) {
                        throw new RuntimeException();
                    }
                }
            }
        };
        Future<Integer> future1 = execService.submit(task1);
//
//        Thread.sleep(1000);
//        System.out.println("future0.isDone() = " + future0.isDone());
//        System.out.println("future1.isDone() = " + future1.isDone());
//
//        System.out.print("future0.get() = ");
//        System.out.println(future0.get());
//        System.out.print("future1.get() = ");
//        System.out.println(future1.get()); //block here!
//        System.out.println("FINISH");

        //---------------------------------------------
        Integer result = execService.invokeAny(Arrays.asList(task0, task1));
        System.out.println(result);

        execService.shutdownNow();
        //---------------------------------------------

        //---------------------------------------------
//        Future<Integer> f0 = execService.submit((Callable<Integer>) null);
//        Future<Integer> f1 = execService.submit((Callable<Integer>) null);
//        Future<Integer> f2 = execService.submit((Callable<Integer>) null);
//        Integer fAny = execService.invokeAny(new ArrayList<Callable<Integer>>());
//        List<Future<Integer>> fAll = execService.invokeAll(new ArrayList<Callable<Integer>>());
//
//        int k = 0;
//        while (k < 3) {
//            f0.get(1, TimeUnit.MILLISECONDS); k++;
//            f0.get(1, TimeUnit.MILLISECONDS); k++;
//            f0.get(1, TimeUnit.MILLISECONDS); k++;
//        }
        //---------------------------------------------
    }
}
