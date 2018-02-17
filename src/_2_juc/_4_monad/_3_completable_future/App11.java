package _2_juc._4_monad._3_completable_future;

import java.util.concurrent.CompletableFuture;

public class App11 {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> "42")
                .thenApply(Integer::valueOf)
                .thenApply(x -> Math.PI * x * x)
                .thenAccept(System.out::println);
    }
}
