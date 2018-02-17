package _2_juc._4_monad._3_completable_future;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class App20 {
    public static void main(String[] args) throws InterruptedException, IOException {
        CompletableFuture<String> future0 = supplyAsync(() -> {
            sleep(3000);
            return "A";
        });
        CompletableFuture<String> future1 = supplyAsync(() -> {
            sleep(1000);
            return "B";
        });

        future0.acceptEitherAsync(future1, System.out::println);

        future0.thenAcceptBothAsync(future1, (a, b) -> System.out.println(a + "#" + b));

        System.in.read();
    }

    private static void sleep(long dt) {
        try {
            Thread.sleep(dt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
