package _3_java8.stream_API;

import java.util.Arrays;
import java.util.stream.Stream;

public class App10 {
    public static void main(String[] args) {
        Arrays.asList("1", "2 33", "4 55 666")
                .stream()
                .flatMap(str -> Arrays.stream(str.split(" ")))
                .forEach(System.out::println);
        int sum = Stream
                .iterate(1, k -> k + 1)
                .limit(10)
                .reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }
}
