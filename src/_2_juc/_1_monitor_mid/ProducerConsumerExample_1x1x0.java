package _2_juc._1_monitor_mid;

public class ProducerConsumerExample_1x1x0 {
    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();
        new Thread(new Producer(1, 1, 1000, buffer)).start();
        new Thread(new Producer(2, 1, 1000, buffer)).start();
        new Thread(new Producer(3, 1, 1000, buffer)).start();
    }
}
