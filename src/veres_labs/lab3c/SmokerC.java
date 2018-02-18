package veres_labs.lab3c;

import static veres_labs.lab3c.Main.*;

public class SmokerC implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                while (!tobacco && !paper) {
                    try {
                        smokerC.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("SmokerC are making and smoking cigarette");
                makingAndSmokingSigarette();
                tobacco = false;
                paper = false;
                matches = false;
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
