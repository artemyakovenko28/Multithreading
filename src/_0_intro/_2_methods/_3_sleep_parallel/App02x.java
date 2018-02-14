package _0_intro._2_methods._3_sleep_parallel;

public class App02x {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int n = 0; n < 5000; n++) {
                    sillyWork();
                    System.out.println("Hello!");
                }
            }
        }).start();

        for (int n = 0; n < 5000; n++) {
            sillyWork();
            System.out.println("Bye!");
        }
    }

    private static void sillyWork() {
        double d = 2.0;
        for (int i = 0; i < 10_000_000; i++) {
            d = Math.sin(d);
        }
    }
}