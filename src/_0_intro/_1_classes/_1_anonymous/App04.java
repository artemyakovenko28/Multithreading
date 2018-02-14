package _0_intro._1_classes._1_anonymous;

public class App04 {
    public static void main(String[] args) {
        Runnable r0 = new Runnable() {
            @Override
            public void run() {
                System.out.println("run()");
            }
        };
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("run()");
            }
        };
        r0.run();
        r1.run();
    }
}
