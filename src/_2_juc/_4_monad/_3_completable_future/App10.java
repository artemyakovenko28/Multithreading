package _2_juc._4_monad._3_completable_future;

import java.util.concurrent.CompletableFuture;

public class App10 {
    public static void main(String[] args) {
        CompletableFuture<String> f0 = CompletableFuture.supplyAsync(() -> {
            for (int k = 0; k < Integer.MAX_VALUE; k++);
                return "42";
        });
        CompletableFuture<Integer> f1 = f0.thenApply(Integer::valueOf);
        CompletableFuture<Double> f2 = f1.thenApply(x -> Math.PI * x * x);
        f2.thenAccept(System.out::println);

        System.out.println("end");
    }
}
