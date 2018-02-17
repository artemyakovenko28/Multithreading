package _2_juc._1_monitor_mid;

public class SingleElementBuffer {
    private Integer elem = null;

    public synchronized void put(int newElem) throws InterruptedException {
        while (elem != null) {
            this.wait();
        }
        elem = newElem;
        this.notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (elem == null) {
            this.wait();
        }
        Integer result = elem;
        elem = null;
        this.notifyAll();
        return result;
    }
}
