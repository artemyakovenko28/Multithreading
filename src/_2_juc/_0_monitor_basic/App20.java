package _2_juc._0_monitor_basic;

public class App20 {
    public static int counter = 0; // shared memory, global variable
    public static volatile boolean finish0 = false;
    public static volatile boolean finish1 = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int k = 0; k < 10_000_000; k++) {
                   increment();
                }
                finish0 = true;
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int k = 0; k < 10_000_000; k++) {
                   increment();
                }
                finish1 = true;
            }
        }).start();

        while (!finish0 || !finish1);

        System.out.println(counter);
    }

    // "lost update"
    private static synchronized void increment() {
        int tmp = counter;
        tmp = tmp + 1;
        counter = tmp;
    }
}
