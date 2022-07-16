package p;

import java.util.Vector;

import static java.lang.Math.sqrt;
import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

public class Definitions {

    Definitions() {
        int i = 100;
        System.out.println("Div: " + i);
        Vector<Integer> Div = div(i);
        // printDiv(Div);
        System.out.println();

//        int a = 98, b = 56;
//        System.out.println("GCD of " + a + " and " + b + " is " + gcd(a, b));

        System.out.println("d(" + i + ") = "
                + d(i));
    }

    public static void main(String[] args) {
        new Definitions();
    }

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        if (a == b)
            return a;
        return a > b ? gcd(a - b, b) : gcd(a, b - a);
    }

    // method to print the divisors
    static Vector<Integer> div(int n) {
        Vector<Integer> v = new Vector<>();
        // Note that this loop runs till square root
        for (int i = 1; i <= sqrt(n); i++) {
            if (n % i == 0) {
                // If divisors are equal, print only one
                if (n / i == i) {
                    System.out.print("*");
                    System.out.print(" " + i);
                } else // Otherwise print both
                    System.out.print(i + " " + n / i + " ");

            }
        }
        return v;
    }


    static int d2(int n) {
        final int[] cnt = {0};
        rangeClosed(1, (int) sqrt(n))
                .filter(i -> n % i == 0)
                .forEach(i -> cnt[0] = n / i == i ? cnt[0] + 1 : cnt[0] + 2);
        return cnt[0];
    }
    static int d(int n) {
        return (int) range(1, n + 1).filter(i -> n % i == 0).count();
    }
    static void printDiv(Vector<Integer> v) {
        for (int i = v.size() - 1; i >= 0; i--)
            System.out.printf("%d ", v.get(i));
    }

}
