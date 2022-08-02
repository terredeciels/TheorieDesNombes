package r;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.lang.System.arraycopy;
import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

public class EA  {

    public int N = 128;
    public int M = N + 1;
    //   String chemin = "/home/tdc/IdeaProjects/LesNombres/src/main/java/nombres/";
    public String chemin = "C:\\Users\\gille\\IdeaProjects\\TheorieDesNombes\\src\\main\\java\\r\\";
    public Supplier<IntStream> I = () -> rangeClosed(2,N);

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
    int[] to1Dtab(int[][] tab2D) {
        int[] tab1D = new int[N * N];
        range(1, N).forEach(i -> arraycopy(tab2D[i], 0, tab1D, i * N, N));
        return tab1D;
    }

}
