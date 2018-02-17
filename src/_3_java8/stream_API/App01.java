package _3_java8.stream_API;

import java.util.stream.Stream;

public class App01 {
//    @FunctionalInterface
//    interface F<T> {
//        T f(T k, T p);
//    }
    public static void main(String[] args) {
//        F<Integer> myF = (x, y) -> x + y;
//        System.out.println(myF);

//        Stream<Long> stream = Stream.iterate(2L, k -> k + 3);
        Stream.iterate(0L, k -> k + 1)
                .filter(k -> k % 3 == 2)
                .map(k -> "~" + k)
                .limit(10)
                .forEach(System.out::println);
    }
}
