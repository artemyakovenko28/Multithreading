package _2_juc._1_monitor_mid;

public class Consumer implements Runnable {
    private final int id;
    private final SingleElementBuffer buffer;

    public Consumer(int id, SingleElementBuffer buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer elem = buffer.get();
                System.out.println("  " + System.currentTimeMillis() + ": " + elem + " consumed by P#" + id);
            } catch (InterruptedException ignore) {/*NOP*/}
        }
    }
}
