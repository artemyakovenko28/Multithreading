package labs.PlayTheAccordion;

public class PlayTheAccordion {
    public static void main(String[] args) throws InterruptedException {
            Thread threadCoordinator = new Thread(new labs.PlayTheAccordion.CoordinatorRunnable());
            threadCoordinator.start();
            threadCoordinator.join();
    }
}
