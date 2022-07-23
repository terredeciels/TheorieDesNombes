package r;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.IntStream.iterate;
import static java.util.stream.IntStream.range;

public class AA extends EA {

    AA() throws IOException {
        range(1, M).forEach(this::add);

        int[][] tab = f();
        matriceToTextFile(tab, chemin, "tab_", N);
        int[][] tab2 = new int[M][M];
        forEach(i -> forEach(j -> tab2[i][j] = D2(i * j).size()));
        matriceToTextFile(tab2, chemin, "tab2_", N);
        int[][] tab3 = new int[M][M];
        forEach(i -> forEach(j -> tab3[i][j] = getDivisors(i * j).size()));
        matriceToTextFile(tab3, chemin, "tab3_", N);
    }

    public static void main(String[] args) throws IOException {
        new AA();
    }

    int[][] f() {
        int[][] tab = new int[M][M];
        forEach(i -> forEach(j -> forEach(k -> forEach(l -> {
            if (k * l == i * j) tab[i][j]++;
        }))));
        return tab;
    }

    List<Integer> getDivisors(int n) {
        List<Integer> div = new ArrayList<>();
        iterate(1, i -> i * i <= n, i -> i + 1).filter(i -> n % i == 0).forEach(i -> {
                    div.add(i);
                    if (i != n / i) div.add(n / i);
                });
        return div;
    }

    List<P> D2(int n) {
        List<Integer> div = getDivisors(n);
        List<P> res = new ArrayList<>();
        for (int d1 : div)
            for (int d2 : div)
                if (d1 * d2 == n && d1 <= N && d2 <= N) res.add(new P(d1, d2));
        return res;
    }


    record P(int i, int j) {
        @Override
        public String toString() {
            return "(" + i + "," + j + ")";
        }
    }

}


