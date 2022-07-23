package s;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

public class B {
    Set<Integer> setA = setOf();
    Set<Integer> setB = setOf();

    B() {

        int N = 32;
        range(1, N).forEach(i -> setA.add(i));
        range(1, N).forEach(i -> setB.add(i));

        Set<Integer> I = inter(setA, setB);


    }

    static Set<Integer> setOf(Integer... values) {
        return new HashSet<>(Arrays.asList(values));
    }

    public static void main(String[] args) {
        new B();
    }

    Set<Integer> inter(Set<Integer> setA, Set<Integer> setB) {
        return setA.stream()
                .filter(setB::contains)
                .collect(Collectors.toSet());
    }
}
