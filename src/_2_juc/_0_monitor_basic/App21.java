package _2_juc._0_monitor_basic;

public class App21 {
    private static volatile int counter = 0; // shared memory, global variable
    private static volatile boolean finish0 = false;
    private static volatile boolean finish1 = false;

    static synchronized int getCounter() {
        return counter;
    }

    // "lost update"
    private static synchronized void increment() {
        int tmp = counter;
        tmp = tmp + 1;
        counter = tmp;
    }

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

        while (true) {
            System.out.println(counter);
//            System.out.println(getCounter());
            if (counter == 20_000_000) break;
        }
    }
}
