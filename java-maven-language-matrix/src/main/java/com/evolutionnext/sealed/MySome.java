package com.evolutionnext.sealed;

import java.util.Objects;
import java.util.StringJoiner;

public final class MySome<T> implements MyOption<T> {
    private final T value;

    public MySome(T value) {
        Objects.requireNonNull(value, "Cannot be null");
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MySome<?> mySome = (MySome<?>) o;
        return value.equals(mySome.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MySome.class.getSimpleName() + "[", "]")
            .add("t=" + value)
            .toString();
    }
}
