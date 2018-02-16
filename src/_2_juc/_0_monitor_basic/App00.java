package _2_juc._0_monitor_basic;

public class App00 {
    public static void main(String[] args) throws InterruptedException {
        Object monitor = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(0);
                synchronized (monitor) {
                    while (true) {
                        System.out.println("A");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                synchronized (monitor) {
                    while (true) {
                        System.out.println("B");
                    }
                }
            }
        }).start();
    }
}
