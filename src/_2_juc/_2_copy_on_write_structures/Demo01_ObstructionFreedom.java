package _2_juc._2_copy_on_write_structures;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo01_ObstructionFreedom {
    /*Если один поток зависнет в блокировке, то другой сможет за конечное колличество шагов закончить
    * свою работу (он независим од другого потока, в отличие от synchronized).
    * "Тупизна" одного потока не зависит от колличества других потоков
    * Задача потока: писать в бесконечном цикле свой id, если блокировка занята, выполнять запасной план*/
    private static int index = 0;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
           while (true) {
               if (lock.tryLock()) {
                   try {
                       int myId = index++;
                       System.out.println(myId);
                   } finally {
                       lock.unlock();
                   }
               } else {
                   // another plan
               }
           }
        }).start();

        new Thread(() -> {
            while (true) {
                if (lock.tryLock()) {
                    try {
                        int myId = index++;
                        System.out.println(myId);
                    } finally {
                        lock.unlock();
                    }
                } else {
                    // another plan
                }
            }
        });
    }
}
