package _3_java8.stream_API;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class App03 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Collections.addAll(set, 0, 1, 2, 3);
        System.out.println(set);
        List<String> list = set
                .stream()
                .map(k -> "~" + k)
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
