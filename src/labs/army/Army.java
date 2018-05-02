package labs.army;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Army {
    static BlockingQueue<Integer> stock = new ArrayBlockingQueue<Integer>(5);
    static BlockingQueue<Integer> lorry = new ArrayBlockingQueue<Integer>(5);
    static Random rnd = new Random();
    static int cost;
    static final int count = 3;

    static class Ivanov implements Runnable {

        @Override
        public void run() {
            for (int k = 0; k < count; k++) {
                int temp = rnd.nextInt(10);
                try {
                    stock.put(temp);
                    System.out.println("Ivanov add: " + temp);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Petrov implements Runnable {

        @Override
        public void run() {
            for (int k = 0; k < count; k++) {
                try {
                    int temp = stock.take();
                    lorry.put(temp);
                    System.out.println("Petrov get: " + temp);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Nech implements Runnable {

        @Override
        public void run() {
            for (int k = 0; k < count; k++) {
                try {
                    int temp = lorry.take();
                    cost += temp;
                    System.out.println("Nech cost: " + cost);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Ivanov()).start();
        new Thread(new Petrov()).start();
        new Thread(new Nech()).start();
    }
}
