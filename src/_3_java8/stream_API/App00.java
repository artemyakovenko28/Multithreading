package _3_java8.stream_API;

import java.util.Arrays;

public class App00 {
    public static void main(String[] args) {
        new Thread(App00::printHello).start();

        new Thread(() -> System.out.println("Hello!"));

        Arrays.asList("A", "BB", "CCC")
                .parallelStream()
                .map(String::length)
                .filter(k -> k % 2 != 0)
                .forEach(System.out::println);
    }

    public static void printHello() {
        System.out.println("Hello!");
    }
}
