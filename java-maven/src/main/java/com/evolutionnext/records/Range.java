package com.evolutionnext.records;

record Range(int min, int max) {
    public Range {
        if (min > max)
            throw new IllegalArgumentException("Max must be >= min");
    }
}
