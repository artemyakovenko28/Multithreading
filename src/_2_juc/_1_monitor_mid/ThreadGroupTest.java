package _2_juc._1_monitor_mid;

public class ThreadGroupTest {
    public static void main(String[] args) {
        final ThreadGroup group = new ThreadGroup("stub");
        Thread.UncaughtExceptionHandler exceptionHandler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                group.interrupt();
            }
        };

        Thread t0 = new Thread(group, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(Long.MAX_VALUE);
                } catch (InterruptedException e) {
                    System.out.println("0 - killed");
                }
            }
        });
        t0.setUncaughtExceptionHandler(exceptionHandler);
        t0.start();

        Thread t1 = new Thread(group, new Runnable() {
            @Override
            public void run() {
                System.out.println("1 - dead");
                throw new Error();
            }
        });
        t1.setUncaughtExceptionHandler(exceptionHandler);
        t1.start();
    }
}
