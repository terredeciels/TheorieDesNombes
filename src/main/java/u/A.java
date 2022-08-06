package u;

import java.util.function.BiFunction;

class A {
    BiFunction<E, E, String> f;

    public A() {
        f = (e, f) -> e.c + e.i + "." + f.c + f.i;

        E a = new E("a", 1), b = new E("a", 2);

        System.out.println(f.apply(a, b));

    }

    public static void main(String[] args) {
        new A();
    }

    record E(String c, int i) {

    }
}
