package _0_intro._1_classes._2_start_run_currentThread_id;

import _0_intro._1_classes._1_anonymous.RunnableImpl;

public class App01 {
    public static void main(String[] args) {
        Runnable r = new RunnableImpl();
        r.run();
    }
}
