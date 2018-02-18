package labs.RabbitAttack;

public class RabbitPrinter implements Runnable {
    @Override
    public void run() {
        System.out.println("New rabbit has born!");
        for (int k = 0; k < 10; k++) {
            String spaces = spaces(k);
            System.out.println(spaces + k);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(new RabbitPrinter()).start();
        }
    }

    private static String spaces(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += " ";
        }
        return result;
    }
}
