package com.evolutionnext.closures;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class ClosureTest {
    @Test
    void testClosureWithFinal() {
        final Integer x = 3;
        Function<Integer, Integer> y = (Integer z) -> x + z;
        assert (Closures.foo(y) == 8);
    }

    @Test
    void testClosureWithEffectivelyFinal() {
        Integer x = 3;
        Function<Integer, Integer> y = (Integer z) -> x + z;
        assert (Closures.foo(y) == 8);
    }
}
