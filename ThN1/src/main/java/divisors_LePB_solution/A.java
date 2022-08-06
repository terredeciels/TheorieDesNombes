package divisors_LePB_solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.IntStream.iterate;
import static java.util.stream.IntStream.range;

class A extends EA {

    A() throws IOException {

        range(1, M).forEach(this::add);
        //CALCUL LePB
        int[][] tab = f();
        matriceToTextFile(tab, chemin, "tab_", N);

        //calcul du nombre de diviseurs D2 ;
        // if (d1 * d2 == n && d1 <= N && d2 <= N)
        int[][] tab2 = new int[M][M];
        forEach(i -> forEach(j -> tab2[i][j] = D2(i * j).size()));
        matriceToTextFile(tab2, chemin, "tab2_", N);
    }

    public static void main(String[] args) throws IOException {
        new A();
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
        iterate(1, i -> i * i <= n, i -> i + 1).filter(i -> n % i == 0)
                .forEach(i -> {
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
                //if (d1 != 1 && d2 != 1 && d1 != n && d2 != n && d1 <= d2 && d1 * d2 == n)
                if (d1 * d2 == n && d1 <= N && d2 <= N) res.add(new P(d1, d2));
        return res;
    }

    private void affiche_paires() {
        forEach(i -> forEach(j -> {
                    System.out.println(D2(i * j));
                    System.out.println(ltab[i][j]);
                    System.out.println();
                }
        ));
    }

    record P(int i, int j) {
        @Override
        public String toString() {
            return "(" + i + "," + j + ")";
        }
    }
}


