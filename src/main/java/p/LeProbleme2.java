package p;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.lang.Math.sqrt;
import static java.util.stream.IntStream.range;

public class LeProbleme2 {
    int N = 128;
    int M = N + 1;
    Supplier<IntStream> I = () -> IntStream.range(1, M);
    //   String chemin = "/home/tdc/IdeaProjects/LesNombres/src/main/java/nombres/";
    String chemin = "C:\\Users\\gille\\IdeaProjects\\TheorieDesNombes\\src\\main\\java\\p\\";

    LeProbleme2() throws IOException {
        //printDiv(div(125));
        // List<Integer> res = div(125);
        //
//        int n = 64;
//        List<Integer> div = div(n);
//        printDiv(div);
        //
        // System.out.println();
//        List<LeProbleme.Px> bifacteurs = dbi(n);
//        for (LeProbleme.Px bifatc : bifacteurs)
//            System.out.println(bifatc);
        //       System.out.println("d(bifact) = " + bifacteurs.size());
        //
        int[][] tab = new int[M][M];
        I.get().forEach(i -> I.get().forEach(j -> tab[i][j] = dbi(i * j)));
        matriceToTextFile(tab, chemin, "tabdbi_", N);
    }

    public static void main(String[] args) throws IOException {
        new LeProbleme2();
    }

    private int dbi(int n) {
        List<Integer> div = div(n);
        List<LeProbleme.Px> bifacteurs = new ArrayList<>();
        for (int d1 : div)
            for (int d2 : div)
                if (d1 != 1 && d2 != 1 && d1 != n && d2 != n && d1 <= d2 && d1 * d2 == n)
                    bifacteurs.add(new LeProbleme.Px(d1, d2, d1 * d2));
        return bifacteurs.size();
    }

    // method to print the divisors
    List<Integer> div(int n) {
        List<Integer> v = new ArrayList<>();
        for (int i = 1; i <= sqrt(n); i++) {
            if (n % i == 0) {
                // If divisors are equal, print only one
                if (n / i == i) {
//                    System.out.print("*");
//                    System.out.print(" " + i);
                    v.add(i);
                } else // Otherwise print both
                {
                    //System.out.print(i + " " + n / i + " ");
                    v.add(i);
                    v.add(n / i);
                }


            }
        }
        // return v.stream().sorted().toList();
        return v;
    }

    void printDiv(List<Integer> v) {
        for (int i = v.size() - 1; i >= 0; i--)
            System.out.printf("%d ", v.get(i));
    }

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
}
