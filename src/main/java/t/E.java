package t;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.IntStream.range;

public class E {

    List<Integer> I = new ArrayList<>();
    int N = 128;
    int M = N + 1;
    int[][] tab = new int[M][M];
    Map<R, Integer> f = new HashMap<>();
    //   String chemin = "/home/tdc/IdeaProjects/LesNombres/src/main/java/nombres/";
    String chemin = "C:\\Users\\gille\\IdeaProjects\\TheorieDesNombes\\src\\main\\java\\t\\";

    E() throws IOException {
        range(1, M).forEach(k -> I.add(k));

        I.forEach(p -> I.forEach(q -> I.forEach(r -> I.forEach(s -> {
            if (p * q == r * s) tab[p][q]++;
        }))));

        I.forEach(p -> I.forEach(q -> f
                .put(new R((double) 1 / p, (double) 1 / q),
                        tab[p][p])));

        matriceToTextFile(f, chemin, "f_", N);
    }


    public static void main(String[] args) throws IOException {
        new E();
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

    record R(Double P, Double Q) {

    }

}
