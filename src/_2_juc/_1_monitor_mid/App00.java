package _2_juc._1_monitor_mid;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * j.u.c:
 * - queue
 * - collections
 * - synchronizers
 * - atomic
 * - ???
 */

//Producers/Consumers
public class App00 {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(16);

        //Producer
        for (int k = 0; k < 3; k++) {
            int finalK = k;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int counter = 0;
                    while (true) {
//                    throw new Error();
                        try {
                            Thread.sleep(300 + 1000 * finalK);
                            String data = "elem-" + finalK + "/" + ++counter;
                            queue.put(data);
                            System.out.println("put: " + data);
                        } catch (InterruptedException ignore) {/*NOP*/}
                    }
                }
            }).start();

            //Consumer
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
//                            System.out.println("... wait for take");
                            String data = queue.take(); // block thread

//                        Integer data = queue.poll(5, TimeUnit.SECONDS); // block thread for 5 seconds
//                        if (data == null) {
//                            System.out.println("No data");
//                        }

//                        Integer data = queue.poll(); // null
//                        Integer data = queue.remove() // NoSuchElementException

                            System.out.println("take: " + data);
                        } catch (InterruptedException ignore) {/*NOP*/}
//                    process(data);
                    }
                }
            }).start();
        }
    }

    private static void process(int data) {
        System.out.println("process: " + data);
    }

}
