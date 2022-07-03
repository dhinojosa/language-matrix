package com.evolutionnext.sealed;

public sealed interface MyOption<T> permits MyNone, MySome {
}
