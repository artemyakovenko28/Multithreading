package _2_juc._0_monitor_basic;

public class App04 {
    public static void main(String[] args) throws InterruptedException {
        Object monitor = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (monitor) {
                        System.out.println("+A");
                        System.out.println("-A");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (monitor) {
                        System.out.println("+B");
                        System.out.println("-B");
                    }
                }
            }
        }).start();
    }
}
