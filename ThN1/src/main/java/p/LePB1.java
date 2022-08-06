package p;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LePB1 extends ELePB {


    List<Px>[][] ltab = new ArrayList[M][M];
    List<Px> X = new ArrayList<>();

    LePB1() throws IOException {
        I.get().forEach(i -> I.get().forEach(j -> {
            ltab[i][j] = new ArrayList<>();
            X.add(new Px(i, j, i * j));
        }));
        ltab = f();
        ltab = complete_triangle();
        tab = d();
        matriceToTextFile(tab, chemin, "tab1_", N);

        /**
         //        int[] valeurs = IntStream.of(to1Dtab(tab)).distinct().sorted().toArray();
         //        System.out.println(Arrays.toString(valeurs));
         //        int val = 2;
         //        int[][] tab1 = equipot(tab, val);
         //        matriceToTextFile(tab1, chemin, "tab1_", N);
         //
         //        int[][] tab2 = dd();
         //        matriceToTextFile(tab2, chemin, "tab2_", N);
         //
         //        int[][] tab3 = dd2();
         //        matriceToTextFile(tab3, chemin, "tab3_", N);
         **/

    }

    public static void main(String[] args) throws IOException {
        new LePB1();
    }

    List<Px>[][] f() {
        for (Px q : X) {
            if (q.i <= q.j) {
                for (Px r : X) {
                    if (q.x == r.x) {
                        ltab[q.i][q.j].add(new Px(r.i, r.j, r.x));
                    }
                }
            }
        }
        return ltab;
    }

    List<Px>[][] complete_triangle() {
        I.get().forEach(i -> I.get().forEach(j -> ltab[j][i] = ltab[i][j]));
        return ltab;
    }

    int[][] d() {
        int[][] tab = new int[M][M];
        I.get().forEach(i -> I.get().forEach(j -> tab[i][j] = ltab[i][j].size()));
        return tab;
    }

    record Px(int i, int j, int x) {
        @Override
        public String toString() {
            return "(" + i + "," + j + ")";
        }
    }

}
