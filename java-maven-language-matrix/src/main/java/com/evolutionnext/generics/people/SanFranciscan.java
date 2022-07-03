package com.evolutionnext.generics.people;

public class SanFranciscan extends NorthernCalifornian {

    public boolean areYouAHipster() {
        return false;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("San Franciscan{");
        sb.append('}');
        return sb.toString();
    }
}
