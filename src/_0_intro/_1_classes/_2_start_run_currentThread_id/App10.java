package _0_intro._1_classes._2_start_run_currentThread_id;

public class App10 {
    public static void main(String[] args) {
        System.out.println("main(): " + Thread.currentThread().getName());
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run(): " + Thread.currentThread().getName());
            }
        });
        newThread.start();
    }
}
