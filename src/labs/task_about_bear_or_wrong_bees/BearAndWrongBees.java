package labs.task_about_bear_or_wrong_bees;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BearAndWrongBees {
    static int N = 10;
    static int M = 10;
    static int forest[][] = new int[N][M];
    volatile static boolean found = false;
    static int ansN, ansM;

    static class Worker implements Runnable {
        int line;
        boolean complete = false;

        public Worker(int line) {
            this.line = line;
        }

        @Override
        public void run() {
            if (!found) {
                for (int j = 0; j < M && (!found); j++) {
                    if (forest[line][j] == 1) {
                        found = true;
                        complete = true;
                        System.out.println(Thread.currentThread().getName() + ": found");
                        ansN = line;
                        ansM = j;
                    }
                }
            }
            if (!complete) {
                System.out.println(Thread.currentThread().getName() + ": not found");
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        int x = rnd.nextInt(M);
        int y = rnd.nextInt(N);
        forest[x][y] = 1;

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < N; i++) {
            Runnable worker = new Worker(i);
            executor.execute(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()) ;
        System.out.println(ansN + " " + ansM);
    }
}
