package com.evolutionnext.generics;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeapPollutionTest {

    /**
     * 21. Heap Pollution Test
     * In this case, let's say a mishap was performed within our code
     * and we accidentally assigned a generic List to the raw List, by
     * bringing the type back as a generic collection this would be a heap
     * pollution because there is no check.
     */
    @Test
    @SuppressWarnings({"unchecked", "UnnecessaryLocalVariable"})
    public void testTypePollution() {
        List ln = Lists.<Number>newArrayList(5,1,3,5,6,10); //Converting to RawType!
        List<String> ls = ln;  // unchecked warning
        assertThatThrownBy(() -> {
            String s = ls.get(0);})
                .isInstanceOf(ClassCastException.class);
    }
}
