package p;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.lang.System.arraycopy;
import static java.util.stream.IntStream.range;

public class ELePB {
    int N = 8;
    int M = N + 1;
    Supplier<IntStream> I = () -> IntStream.range(1, M);
    //   String chemin = "/home/tdc/IdeaProjects/LesNombres/src/main/java/nombres/";
    String chemin = "C:\\Users\\gille\\IdeaProjects\\TheorieDesNombes\\src\\main\\java\\p\\";
    int[][] tab= new int[M][M];

    void matriceToTextFile(int[][] tab, String fileaddr, String filename, int n) throws IOException {
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

    int[] to1Dtab(int[][] tab2D) {
        int[] tab1D = new int[M * M];
        range(1, M).forEach(i -> arraycopy(tab2D[i], 0, tab1D, i * M, M));
        return tab1D;
    }

    int gcd(int a, int b) {
       if (a == 0)
           return b;
       if (b == 0)
           return a;
       if (a == b)
           return a;
       return a > b ? gcd(a - b, b) : gcd(a, b - a);
   }

    String format(List<LePB1.Px>[][] tab) {
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

    int[][] equipot(int[][] tab, int val) {
        int[][] t = new int[M][M];
        I.get().forEach(i -> I.get().forEach(j -> {
            if (tab[i][j] == val) t[i][j] = 1;
        }));
        return t;
    }

    int d(int n) {
        return (int) range(1, n + 1).filter(i -> n % i == 0).count();
    }

    int[][] dd() {
        int[][] tab = new int[M][M];
        I.get().forEach(i -> I.get().forEach(j -> tab[i][j] = d(i * j)));
        return tab;
    }

    int[][] dd2() {
        int[][] tab = new int[M][M];
        I.get().forEach(i -> I.get().forEach(j -> tab[i][j] = d(i) * d(j)));
        return tab;
    }
}
