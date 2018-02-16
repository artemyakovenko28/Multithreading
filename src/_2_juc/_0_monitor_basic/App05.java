package _2_juc._0_monitor_basic;

public class App05 {
    public static volatile boolean in = false;
    public static void main(String[] args) throws InterruptedException {
        Object monitor = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (monitor) {
                        in = true;
                        try {
                            Thread.sleep(Long.MAX_VALUE);
                        } catch (InterruptedException ignore) {/* NOP */}
                    }
                }
            }
        }).start();

        System.out.println("A");
        while (!in); // spin lock / busy waiting
        System.out.println("B");
        synchronized (monitor) {
            System.out.println("C");
        }
    }
}
