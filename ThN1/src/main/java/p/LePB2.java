package p;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class LePB2 extends ELePB {

    LePB2() throws IOException {
        I.get().forEach(i -> I.get().forEach(j -> tab[i][j] = d(i * j)));
        matriceToTextFile(tab, chemin, "tab2_", N);
    }

    public static void main(String[] args) throws IOException {
        new LePB2();
    }

    int d(int n) {
        List<Integer> div = diviseur(n);
        List<LePB1.Px> bifacteurs = new ArrayList<>();
        for (int d1 : div)
            for (int d2 : div)
                //if (d1 != 1 && d2 != 1 && d1 != n && d2 != n && d1 <= d2 && d1 * d2 == n)
                if (d1 * d2 == n) bifacteurs.add(new LePB1.Px(d1, d2, d1 * d2));
        return bifacteurs.size();
    }

    List<Integer> diviseur(int n) {
        List<Integer> v = new ArrayList<>();
        for (int i = 1; i <= sqrt(n); i++)
            if (n % i == 0) {
                v.add(i);
                if (n / i != i) v.add(n / i);

            }
        // return v.stream().sorted().toList();
        return v;
    }


}
