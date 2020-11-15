package com.evolutionnext.diamondoperator;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.evolutionnext.diamondoperator.DiamondOperator.fillValuesImmutably;
import static org.assertj.core.api.Assertions.assertThat;

public class DiamondOperatorTest {

    /**
     * Previous to Java 7, you had to declare all generic types when
     * instantiating a parameterized object
     */
    @SuppressWarnings("Convert2Diamond")
    @Test
    void testJava7Format() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        assertThat(map).isEmpty();
    }

    /**
     * With the diamond operator you can can just include the
     * diamond operator `<>` and the parameterized type will be inferred
     */
    @Test
    void testJavaDiamondOperator() {
        Map<String, Integer> map = new HashMap<>();
        assertThat(map).isEmpty();
    }

    /**
     * The diamond operator can also be used when sending it as
     * a parameter to a method, the parameterized types will be
     * inferred
     */
    @Test
    void testJavaDiamondOperatorAsAParameter() {
        Map<String, Integer> copy = fillValuesImmutably(new HashMap<>());
        assert (copy.size() == 3);
    }
}
