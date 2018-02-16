package _2_juc._0_monitor_basic;

public class App08 {
    public static volatile boolean in = false;

    public static void main(String[] args) throws InterruptedException {
        Object monitor = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (monitor) {
                    in = true;
                    try {
                        System.out.println("X");
                        monitor.wait();
                        System.out.println("Y");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        System.out.println("A");
        while (!in) ; // spin lock / busy waiting
        System.out.println("B");
        synchronized (monitor) {
            System.out.println("C");
            monitor.notify();
            System.out.println("D");
        }
        System.out.println("E");
    }
}
