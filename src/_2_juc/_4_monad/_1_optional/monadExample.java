package _2_juc._4_monad._1_optional;

import java.util.Optional;
import java.util.stream.Stream;

public class monadExample {
    public static void main(String[] args) {
        //Monad Optional / Maybe

        //Редукция на моноиде (ассоциативном опетаторе + нейтральный элемент
        Integer sum0 = Stream.of(1, 2, 3).reduce(0, (x, y) -> x + y);
        System.out.println(sum0);

        //Редукция на ассоциативном операторе
        //МОНАДА: Optional / Just
        Optional<Integer> sum1 = Stream.of(1, 2, 3).reduce((x, y) -> x + y);
        System.out.println(sum1);

        //Редукция на ассоциативном операторе
        //МОНАДА: Optional / Nothing
        Optional<Integer> sum2 = Stream.of(1, 2, 3).filter(x -> x > 10).reduce((x, y) -> x + y);
        System.out.println(sum2);
    }
}
