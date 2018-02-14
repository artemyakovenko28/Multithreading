package _0_intro._1_classes.daemon;

public class App01 {
    public static void main(String[] args) {
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {/*NOP*/}
            }
        });
        newThread.setDaemon(true);
        newThread.start();
        System.out.println("Bye!");
    }
}
