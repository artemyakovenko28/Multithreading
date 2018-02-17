package _2_juc._4_monad._1_optional;

import java.util.Optional;
import java.util.stream.Stream;

public class App10 {
    public static void main(String[] args) {
        {
            Optional<Integer> sum = Stream.of(1, 2, 3).reduce((x, y) -> x + y);
            Optional<Integer> sqr = sum.map(x -> x * x);
            Optional<String> str = sqr.map(x -> "#" + x);
            System.out.println(str);
        }

        {
            Optional<Integer> sum = Stream.of(1, 2, 3).filter(x -> x > 10).reduce((x, y) -> x + y);
            Optional<Integer> sqr = sum.map(x -> x * x);
            Optional<String> str = sqr.map(x -> "#" + x);
            System.out.println(str);

        }
    }
}
