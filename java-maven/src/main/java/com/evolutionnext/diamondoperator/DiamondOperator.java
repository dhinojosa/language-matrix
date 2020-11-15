package com.evolutionnext.diamondoperator;

import java.util.HashMap;
import java.util.Map;

public class DiamondOperator {
    public static Map<String, Integer> fillValuesImmutably
        (Map<String, Integer> map) {
        Map<String, Integer> copy = new HashMap<>();
        copy.put("One", 1);
        copy.put("Two", 2);
        copy.put("Three", 3);
        return copy;
    }
}
