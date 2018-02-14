package _0_intro._1_classes._1_anonymous;

public class App03 {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("run()");
            }
        };
        r.run();
    }
}
