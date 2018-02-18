package veres_labs.lab3c;

import static veres_labs.lab3c.Main.*;

public class SmokerA implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                while (!paper && !matches) {
                    try {
                        smokerA.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("SmokerA are making and smoking cigarette");
                paper = false;
                matches = false;
                tobacco = false;
                makingAndSmokingSigarette();
                pusher.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    private void makingAndSmokingSigarette() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
