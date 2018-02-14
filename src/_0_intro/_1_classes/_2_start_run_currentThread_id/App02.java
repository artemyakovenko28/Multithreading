package _0_intro._1_classes._2_start_run_currentThread_id;

import _0_intro._1_classes._1_anonymous.RunnableImpl;

public class App02 {
    public static void main(String[] args) {
        Runnable r = new RunnableImpl();
        Thread newThread = new Thread(r);
        newThread.start();
    }
}
