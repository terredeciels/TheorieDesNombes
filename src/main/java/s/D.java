package s;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

public class D {

    List<Integer> I = new ArrayList<>();
    List<Q> Qm = new ArrayList<>();
    int N = 32;
    int M = N + 1;
    int[][][][] tab = new int[M][M][M][M];
    Map<R, Integer> f = new HashMap<>();
    //   String chemin = "/home/tdc/IdeaProjects/LesNombres/src/main/java/nombres/";
    String chemin = "C:\\Users\\gille\\IdeaProjects\\TheorieDesNombes\\src\\main\\java\\s\\";

    D() throws IOException {
        range(1, M).forEach(k -> I.add(k));
        I.forEach(n -> I.forEach(d -> Qm.add(new Q(n, d))));
        Qm.forEach(p -> Qm.forEach(q -> Qm.forEach(r -> Qm.forEach(s -> {
            if (p.x(q).eq(r.x(s))) {
                tab[p.n][p.d][q.n][q.d]++;
                f.put(new R((double) (p.n / p.d), (double) (q.n / q.d)), tab[p.n][p.d][q.n][q.d]);
            }
        }))));
        matriceToTextFile(f, chemin, "f_", N);
    }


    public static void main(String[] args) throws IOException {
        new D();
    }

    private void matriceToTextFile(Map<R, Integer> f, String fileaddr, String filename, int n) throws IOException {
        StringBuilder result = new StringBuilder();
        for (R r : f.keySet()) {
            String s = r.P + "," + r.Q + "," + f.get(r) + "\n";
            result.append(s);
        }
        String sb = result.toString();

        FileWriter fw = new FileWriter(fileaddr + filename + n + ".txt", false);
        BufferedWriter output = new BufferedWriter(fw);
        output.write(sb);
        output.flush();
        output.close();
    }

    record Q(int d, int n) {
        Q x(Q p) {
            return new Q(d * p.d, n * p.n);
        }

        public boolean eq(Q p) {
            return n * p.d == p.n * d;
        }

    }

    record R(Double P, Double Q) {

    }

}
