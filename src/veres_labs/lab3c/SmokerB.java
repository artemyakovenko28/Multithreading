package veres_labs.lab3c;

import static veres_labs.lab3c.Main.*;

public class SmokerB implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                while (!tobacco && !matches) {
                    try {
                        smokerB.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("SmokerB are making and smoking cigarette");
                tobacco = false;
                matches = false;
                paper = false;
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
