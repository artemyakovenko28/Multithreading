package _0_intro._2_methods._3_sleep_parallel;

public class App01 {
    public static void main(String[] args) throws InterruptedException {
        for (int n = 0; n < 5; n++) {
            Thread.sleep(1000);
            System.out.println("Hello!");
        }
    }
}
