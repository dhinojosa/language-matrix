package com.evolutionnext.patternmatching;

public class PatternMatching {
    public static String match(Object o) {
       if (o instanceof String s) {
           if ("Hello".equals(s)) return "Hello to you";
           else return "A String";
       } else if (o instanceof Integer i) {
           return String.valueOf(i + 30);
       }
       return "Nothing";
    }


    public static String compoundMatch(Object o) {
        if (o instanceof String s && !s.isEmpty()) {
            return "non empty string";
        }
        return "not a string or is empty";
    }
}
