package _0_intro._1_classes._1_anonymous;

public class App02 {
    public static void main(String[] args) {
        Runnable r0 = new RunnableImpl();
        Runnable r1 = new RunnableImpl();
        r0.run();
        r1.run();
    }
}
