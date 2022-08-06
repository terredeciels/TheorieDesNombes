package r;

import visualiser.Visu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.iterate;

public class AA extends EA {

    AA() throws IOException {
//        List<Integer> X = new ArrayList<>();
//        I.get().forEach(X::add);
        int[][] f = f();
        matriceToTextFile(f, chemin, "tab2_", N);

//        int[][] tab2 = new int[M][M];
//        I.get().forEach(i -> I.get().forEach(j -> tab2[i][j] = D2(i * j).size()));
//        matriceToTextFile(tab2, chemin, "tab2_", N);
//        int[][] tab3 = new int[M][M];
//        I.get().forEach(i -> I.get().forEach(j -> tab3[i][j] = getDivisors(i * j).size()));
//        matriceToTextFile(tab3, chemin, "tab3_", N);


        int[] valeurs = IntStream.of(to1Dtab(f)).distinct().sorted().toArray();
        System.out.println(Arrays.toString(valeurs));
        new Visu(f, N, valeurs);
    }

    public static void main(String[] args) throws IOException {
        new AA();
    }

    int[][] f() {
        int[][] tab = new int[M][M];
        I.get().forEach(i -> I.get().forEach(j -> I.get().forEach(k -> I.get().forEach(l -> {
            if (distinct(i, j, k, l) && k * l == i * j) tab[i][j]++;
            // if ( k * l == i * j) tab[i][j]++;
        }))));
        return tab;
    }

    boolean distinct(int i, int j, int k, int l) {
        return i != k && i != l && j != k && j != l & i != j && k != l;
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


