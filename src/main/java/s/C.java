package s;

import r.EA;

import java.io.IOException;
import java.util.function.Function;

import static java.util.stream.IntStream.range;

public class C extends EA {

    Function<A, Integer> F2 = x -> x.i * x.l - x.j * x.k;
    Function<A, Integer> F1 = x -> x.k * x.l - x.i * x.j;

    C() throws IOException {
        range(1, M).forEach(this::add);
        int[][] tab = f(F1);
        matriceToTextFile(tab, chemin, "tab_", N);

    }

    public static void main(String[] args) throws IOException {
        new C();
    }

    int[][] f(Function<A, Integer> F) {
        int[][] tab = new int[M][M];
        forEach(i -> forEach(j -> forEach(k -> forEach(l -> {
            A x = new A(i, j, k, l);
            if (F.apply(x) == 0) tab[x.i][x.j]++;
        }))));
        return tab;
    }

    record A(Integer i, Integer j, Integer k, Integer l) {
    }
}
