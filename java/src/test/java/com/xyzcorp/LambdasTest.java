package com.xyzcorp;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class LambdasTest {

    @Test
    public void testMyFilter() {
        List<Integer> numbers = Arrays.asList(2, 4, 5, 1, 9, 15, 19, 21, 33, 78, 93, 10);
        List<Integer> filtered = Functions.myFilter(numbers, item -> item % 2 == 0);
        System.out.println(filtered);
    }

    @Test
    public void testMyMap() {
        List<Integer> numbers = Arrays.asList(2, 4, 5, 1, 9, 15, 19, 21, 33, 78, 93, 10);
        List<Integer> mapped = Functions.myMap(numbers, new MyFunction<Integer, Integer>() {
            @Override
            public Integer apply(Integer item) {
                return item + 2;
            }
        });
        System.out.println(mapped);
    }

    @Test
    public void testForEach() {
        List<Integer> numbers = Arrays.asList(2, 4, 5, 1, 9, 15, 19, 21, 33, 78, 93, 10);
        Functions.myForEach(numbers, System.out::println);
    }

    @Test
    public void testMethodReferenceAStaticMethod() {
        List<Integer> numbers = Arrays.asList(2, 4, 5, 1, 9, 15, 19, 21, 33, 78, 93, 10);
        System.out.println(Functions.myMap(numbers, a -> Math.abs(a)));
    }

    @Test
    public void testMethodReferenceAContainingType() {
        List<String> words = Arrays.asList("One", "Two", "Three", "Four");
        System.out.println(Functions.myMap(words, (s) -> s.length()));
    }

    @Test
    public void testMethodReferenceAContainingTypeTrickQuestion() {
        List<Integer> numbers = Arrays.asList(2, 4, 5, 1, 9, 15, 19, 21, 33, 78, 93, 10);
        System.out.println(Functions.myMap(numbers, number -> number.toString()));
    }

    @Test
    public void testMethodReferenceAnInstance() {
        List<Integer> numbers = Arrays.asList(2, 4, 5, 1, 9, 15, 19, 21, 33, 78, 93, 10);
        TaxRate taxRate2016 = new TaxRate(2016, .085);
        System.out.println(Functions.myMap(numbers, subtotal -> taxRate2016.apply(subtotal)));
    }

    @Test
    public void testMethodReferenceANewType() {
        List<Integer> numbers = Arrays.asList(2, 4, 5, 1, 9, 15, 19, 21, 33, 78, 93, 10);
        System.out.println(Functions.myMap(numbers, value -> new Double(value)));
    }

    @Test
    public void testMyGenerate() {
        List<LocalDateTime> localDateTimes = Functions.myGenerate(new MySupplier<LocalDateTime>() {
            @Override
            public LocalDateTime get() {
                return LocalDateTime.now();
            }
        }, 10);
        System.out.println(localDateTimes);
    }

    @Test
    public void testLambdasWithRunnable() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String threadName =
                        Thread.currentThread().getName();
                System.out.format("%s: %s%n",
                        threadName,
                        "Hello from another thread");
            }
        });
        t.start();
    }

    public static Integer foo(Function<Integer, Integer> f) {
        return f.apply(5);
    }

    @Test
    public void testClosures() {
        //http://gafter.blogspot.co.uk/2007/01/definition-of-closures.html

        final Integer x = 3;
        Function<Integer, Integer> add3 =
                z -> x + z;
        System.out.println(foo(add3));
    }


    public MyPredicate<String> stringHasSizeOf(final int length) {
        return s -> s.length() == length;
    }

    @Test
    public void testClosuresAvoidRepeats() {
        List<String> names = Arrays.asList("Foo", "Ramen", "Naan", "Ravioli");
        System.out.println(Functions.myFilter(names, stringHasSizeOf(4)));
        System.out.println(Functions.myFilter(names, stringHasSizeOf(4)));
    }
}
