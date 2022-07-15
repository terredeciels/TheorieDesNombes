package p;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public class LeProbleme {

    int N = 32;
    int M = N + 1;
    List<Px>[][] ltab = new ArrayList[M][M];
    Supplier<IntStream> I = () -> IntStream.range(1, M);
    List<Px> X = new ArrayList<>();

    //   String chemin = "/home/tdc/IdeaProjects/LesNombres/src/main/java/nombres/";
    String chemin = "Definitions:\\Users\\gille\\IdeaProjects\\TheorieDesNombes\\src\\main\\java\\p\\";

    LeProbleme() throws IOException {
        I.get().forEach(i -> I.get().forEach(j -> {
            ltab[i][j] = new ArrayList<>();
            X.add(new Px(i, j, i * j));
        }));
        ltab = f();
        complete_triangle();
        // System.out.println(format(ltab));

        int[][]  tab = d();
        matriceToTextFile(tab, chemin, "tab_", N);

    }

    public static void main(String[] args) throws IOException {
        new LeProbleme();
    }

    void complete_triangle(){
        I.get().forEach(i -> I.get().forEach(j -> ltab[j][i] =  ltab[i][j]));
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

    int[][] d() {
        int[][] tab =  new int[M][M];
        I.get().forEach(i -> I.get().forEach(j -> tab[i][j] = ltab[i][j].size()));
        return tab;
    }

    String format(List<Px>[][] tab) {
        StringBuilder sb = new StringBuilder();
        I.get().forEach(i -> I.get().forEach(j -> {
            if (i <= j) {
                sb.append("(").append(i).append(",").append(j).append(") ").append(i * j).append(" : ");
                tab[i][j].forEach(p -> sb.append(p).append(" "));
                sb.append("\n");
            }
        }));
        return sb.toString();
    }

    private void matriceToTextFile(int[][] tab, String fileaddr, String filename, int n) throws IOException {
        StringBuilder sb = new StringBuilder();
        range(1, n).forEach(i -> {
            range(1, n).forEach(j -> sb.append(tab[i][j]).append(","));
            sb.append("\n");
        });

        FileWriter fw = new FileWriter(fileaddr + filename + n + ".txt", false);
        BufferedWriter output = new BufferedWriter(fw);
        output.write(sb.toString());
        output.flush();
        output.close();

    }

    record Px(int i, int j, int x) {
        @Override
        public String toString() {
            return "(" + i + "," + j + ")";
        }
    }
}
