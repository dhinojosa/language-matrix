package com.evolutionnext.generics;

import java.util.List;

public class CaptureWildcardTest {

    public void process(List<?> list) {
        processHelper(list);
    }

    private <E> void processHelper(List<E> list) {
        list.add(list.get(0));
    }
}
