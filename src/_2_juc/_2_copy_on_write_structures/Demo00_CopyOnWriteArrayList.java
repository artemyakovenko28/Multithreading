package _2_juc._2_copy_on_write_structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo00_CopyOnWriteArrayList {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();

        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        List<Integer> synchronizedArrayList = Collections.synchronizedList(new ArrayList<>());
    }
}
