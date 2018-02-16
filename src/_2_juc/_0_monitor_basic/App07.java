package _2_juc._0_monitor_basic;

public class App07 {
    public static volatile boolean in = false;

    public static void main(String[] args) throws InterruptedException {
        Object monitor = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (monitor) {
                    in = true;
                    while (true) {
                        Thread.yield();
                    }
                }
            }
        }).start();

        Thread.sleep(1000);

        System.out.println("A");
        System.out.println("B");
        synchronized (monitor) {
            System.out.println("C");
        }
    }
}
