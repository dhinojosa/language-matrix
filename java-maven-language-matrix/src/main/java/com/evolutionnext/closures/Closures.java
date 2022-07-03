package com.evolutionnext.closures;

import java.util.function.Function;

public class Closures {
    public static Integer foo(Function<Integer, Integer> w) {
        return w.apply(5);
    }
}
