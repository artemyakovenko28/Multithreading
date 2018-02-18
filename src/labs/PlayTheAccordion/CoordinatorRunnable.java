package labs.PlayTheAccordion;

public class CoordinatorRunnable implements Runnable {
    @Override
    public void run() {
        for (int k = 0; k < 10; k++) {
            Runnable printerA = new PrintRunnable("A   .", 99);
            Thread threadA = new Thread(printerA);
            threadA.start();

            Runnable printerB = new PrintRunnable(".   B", 100);
            Thread threadB = new Thread(printerB);
            threadB.start();

            try {
                threadA.join();
                threadB.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("-----");
            Runnable printerC = new PrintRunnable("  C", 100);
            Thread threadC = new Thread(printerC);
            threadC.start();
            try {
                threadC.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-----");
        }
    }
}
