package divisors_LePB_solution;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.lang.System.arraycopy;
import static java.util.stream.IntStream.range;

public class EA extends ArrayList<Integer> {
    //   String chemin = "/home/tdc/IdeaProjects/LesNombres/src/main/java/nombres/";
    public String chemin = "C:\\Users\\gille\\IdeaProjects\\TheorieDesNombes\\ThN1\\src\\main\\java\\divisors_LePB_solution\\";

    int N = 32;
    public Supplier<IntStream> I = () -> range(1, N);
    int M = N + 1;
    List<A.P>[][] oltab = new ArrayList[M][M];
    List<A.P>[][] ltab = new ArrayList[M][M];

    public void matriceToTextFile(int[][] tab, String fileaddr, String filename, int n) throws IOException {
        StringBuilder sb = new StringBuilder();
        I.get().forEach(i -> {
            I.get().forEach(j -> sb.append(tab[i][j]).append(","));
            sb.append("\n");
        });

        FileWriter fw = new FileWriter(fileaddr + filename + n + ".txt", false);
        BufferedWriter output = new BufferedWriter(fw);
        output.write(sb.toString());
        output.flush();
        output.close();

    }
     void fonctionToTextFile(Map<Integer, Integer> F, String fileaddr, String filename, int n) throws IOException {
        StringBuilder sb = new StringBuilder();
        F.forEach((key, value) -> sb.append(key).append(",").append(value).append("\n"));
        System.out.println(sb);
        FileWriter fw = new FileWriter(fileaddr + filename + n + ".txt", false);
        BufferedWriter output = new BufferedWriter(fw);
        output.write(sb.toString());
        output.flush();
        output.close();

    }

    int[] to1Dtab(int[][] tab2D) {
        int[] tab1D = new int[N * N];
        for (int i = 1; i < N; i++) arraycopy(tab2D[i], 0, tab1D, i * N, N);
        return tab1D;
    }
    void f2() {

        forEach(i -> forEach(j -> {
            ltab[i][j] = new ArrayList<>();
        }));

        forEach(i -> forEach(j -> forEach(k -> forEach(l -> {
            if (k * l == i * j) ltab[i][j].add(new A.P(k, l));
        }))));


    }
}
