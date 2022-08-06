package v;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.rangeClosed;

class A {

    int N = 3;
    Supplier<IntStream> I = () -> rangeClosed(0, N);
    List<P> X = new ArrayList<>();
    List<R2> R_2 = new ArrayList<>();

    {
        I.get().forEach(i -> I.get().forEach(j -> {
            if (i < j) X.add(new P(i, j));
        }));
    }

    public A() {

        X.forEach(x -> X.forEach(y -> {
            if (distinct(x, y)) R_2.add(new R2(x, y));

        }));

        StringBuilder sb = new StringBuilder();
        for (R2 r2 : R_2)
            sb.append("[(")
                    .append(r2.x.i).append(",").append(r2.x.j).append("),(")
                    .append(r2.y.i).append(",").append(r2.y.j).append(")]").append("\n");
        System.out.println(sb);
        System.out.println(R_2.size());
    }

    public static void main(String[] args) {
        new A();
    }

    boolean distinct(P x, P y) {
        return x.i != y.i && x.j != y.j && x.i != y.j && x.j != y.i;
    }

    record P(int i, int j) {
    }

    record R2(P x, P y) {
    }
}
