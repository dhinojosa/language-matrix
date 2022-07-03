package com.evolutionnext.httpclient;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Function;

public class Pair<A, B> {
    private A a;
    private B b;

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    public <C> Pair<C, B> mapFirst(final Function<A, C> function) {
        return new Pair<>(function.apply(a), b);
    }

    public <C> Pair<A, C> mapSecond(final Function<B, C> function) {
        return new Pair<>(a, function.apply(b));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(a, pair.a) &&
            Objects.equals(b, pair.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Pair.class.getSimpleName() + "[", "]")
            .add("a=" + a)
            .add("b=" + b)
            .toString();
    }
}
