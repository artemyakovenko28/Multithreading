package _0_intro._2_methods.join;

public class App00 {
    public static void main(String[] args) throws InterruptedException {
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int n = 0; n < 10; n++) {
                    sillyWork();
                    System.out.println("Hello!");
                }
            }
        });
        newThread.start();

        for (int n = 0; n < 5; n++) {
            sillyWork();
            System.out.println("Bye!");
        }
        newThread.join();
        System.out.println("That's all!");
    }

    private static void sillyWork() {
        double d = 2.0;
        for (int i = 0; i < 10_000_000; i++) {
            d = Math.sin(d);
        }
    }
}