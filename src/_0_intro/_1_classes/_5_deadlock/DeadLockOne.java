package _0_intro._1_classes._5_deadlock;

public class DeadLockOne {
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().join();
    }
}
