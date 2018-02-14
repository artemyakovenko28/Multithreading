package _0_intro._1_classes._1_anonymous;

public class App05 {
    public static void main(String[] args) {
        for (int k = 0; k < 10; k++) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    System.out.println("run()");
                }
            };
            r.run();
        }
    }
}
