package p;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class LeProbleme2 {


    LeProbleme2() {
        //printDiv(div(125));
        // List<Integer> res = div(125);
        //
        int n = 64;
        List<Integer> div = div(n);
        printDiv(div);
        System.out.println();
        List<LeProbleme.Px> bifacteurs = new ArrayList<>();
        for (int d1 : div)
            for (int d2 : div)
                if (d1 != 1 && d2 != 1 && d1 != n && d2 != n && d1 <= d2 && d1 * d2 == n)
                    bifacteurs.add(new LeProbleme.Px(d1, d2, d1 * d2));
        for (LeProbleme.Px bifatc : bifacteurs)
            System.out.println(bifatc);
        System.out.println("d(bifact) = "+bifacteurs.size());
    }

    public static void main(String[] args) {
        new LeProbleme2();
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

}
