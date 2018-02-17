package _2_juc._1_monitor_mid;

public class SingleElementBuffer_PrivateMutex {
    private Integer elem = null;
    private final Object lock = new Object();

    public void put(int newElem) throws InterruptedException {
        synchronized (lock) {
            while (elem != null) {
                lock.wait();
            }
            elem = newElem;
            lock.notifyAll();
        }
    }

    public int get() throws InterruptedException {
        synchronized (lock) {
            while (elem == null) {
                lock.wait();
            }
            Integer result = elem;
            elem = null;
            lock.notifyAll();
            return result;
        }
    }
}
