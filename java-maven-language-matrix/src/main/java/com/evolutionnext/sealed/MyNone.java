package com.evolutionnext.sealed;

import java.util.StringJoiner;

public final class MyNone implements MyOption<Void> {
    public MyNone() {}

    @Override
    public String toString() {
        return new StringJoiner(", ", MyNone.class.getSimpleName() + "[", "]")
            .toString();
    }
}
