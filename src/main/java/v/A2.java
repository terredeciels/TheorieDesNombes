package v;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.rangeClosed;

class A2 {


    int N = 5;
    Supplier<IntStream> I = () -> rangeClosed(0, N);
    List<P> X = new ArrayList<>();
    List<R2> R_2 = new ArrayList<>();
    List<P> R_3 = new ArrayList<>();

    {
        I.get().forEach(i -> I.get().forEach(j -> {
            if (i < j) X.add(new P(i, j));
        }));
    }

    public A2() {

        X.forEach(x -> X.forEach(y -> {
            if (distinct(x, y)) R_2.add(new R2(x, y));

        }));
        final int[] k = {0};
        for (R2 r2 : R_2) {
            X.forEach(p -> {
                if (distinct(r2.x, p) && distinct(r2.y, p)) {
                    R_3.add(k[0], p);
                } else {
                    R_3.add(new P(0, 0));
                }
                k[0]++;

            });
        }

        StringBuilder sb = new StringBuilder();
        int n = 0;
        for (R2 r2 : R_2) {
            sb.append("(").append(r2.x.i).append(",").append(r2.x.j).append("),(").append(r2.y.i).append(",").append(r2.y.j).append("),");
            //if (R_3.get(n).i != 0 && R_3.get(n).j != 0)
            sb.append("(").append(R_3.get(n).i).append(",").append(R_3.get(n).j).append(")");
            sb.append("\n");
            n++;
        }
        System.out.println(sb);
        System.out.println(R_2.size());

    }

    public static void main(String[] args) {
        new A2();
    }

    boolean distinct(P a, P b) {
        return a.i != b.i && a.j != b.j && a.i != b.j && a.j != b.i;
    }

    record P(int i, int j) {
    }

    record R2(P x, P y) {
    }
}
