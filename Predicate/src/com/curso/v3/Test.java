package com.curso.v3;

import java.util.function.Predicate;

class Foo {
    int i;

    Foo(int i) {
        this.i = i;
    }
}

public class Test {

    static boolean compare(Foo foo, Predicate<Foo> predicate) {
        return predicate.test(foo);
    }

    public static void main(String[] args) {

        Predicate<Foo> pre1 = f -> f.i > 0; // line 1
        Predicate<Foo> pre2 = f -> f.i > 0;
        Predicate<Foo> pre3 = f -> f.i < 0;
        Predicate<Foo> pre4;

        pre4 = pre1.or(pre2);
        pre4 = pre4.and(pre3);

        boolean b = compare(new Foo(1), pre4); // line 3

        System.out.println(b);
    }
}