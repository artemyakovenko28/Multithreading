package _0_intro._2_methods._3_sleep_parallel;

public class App00 {
    public static void main(String[] args) {
        for (int n = 0; n < 5; n++) {
            sillyWork();
            System.out.println("Hello!");
        }
    }

    private static void sillyWork() {
        double d = 2.0;
        for (int i = 0; i < 10_000_000; i++) {
            d = Math.sin(d);
        }
    }
}
