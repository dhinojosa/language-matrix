package com.evolutionnext.functions;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class FunctionsTest {

    @Test
    public void testMyFilter() {
        List<Integer> numbers = Arrays.asList(4, 5, 7, 8, 10, 11, 14, 15);
        List<Integer> result = Functions.myFilter(numbers,
            item -> item % 2 == 0);
        assertEquals(Arrays.asList(4, 8, 10, 14), result);
    }

    @Test
    public void testMyMap() {
        List<Integer> numbers = Arrays.asList(4, 5, 7, 8);
        List<Integer> mapped = Functions.myMap(numbers, t -> t + 2);
        assertEquals(Arrays.asList(6, 7, 9, 10), mapped);
    }

    @Test
    public void testMyFlatMap() {
        List<Integer> numbers = Arrays.asList(4, 5, 7, 8);
        List<Integer> mapped = Functions.myFlatMap(numbers,
            t -> List.of(t - 1, t, t + 1));
        assertEquals(Arrays.asList(3, 4, 5, 4, 5, 6, 6, 7, 8, 7, 8, 9), mapped);
    }

    @Test
    public void testMyForEach() {
        List<Integer> numbers = Arrays.asList(4, 5, 7, 8);
        Functions.myForEach(numbers, new MyConsumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        });
    }

    @Test
    public void testMethodReferenceAStaticMethod() {
        List<Integer> numbers = Arrays.asList(2, 4, 5, 1, 9, 15, 19,
            21, 33, 78, 93, 10);
        System.out.println(Functions.myMap(numbers, Math::abs));
    }

    @Test
    public void testMethodReferenceAContainingType() {
        List<String> words = Arrays.asList("One", "Two", "Three", "Four");
        List<Integer> result = Functions.myMap(words, String::length);
        System.out.println(result);
    }

    @Test
    public void testMethodReferenceAContainingTypeTrickQuestion() {
        List<Integer> numbers = Arrays.asList(2, 4, 5, 1, 9, 15, 19,
            21, 33, 78, 93, 10);
        System.out.println(Functions.myMap(numbers, Object::toString));
    }


    @Test
    public void testTwoOrMoreItemsInALambda() {
        List<Integer> numbers = Arrays.asList(2, 4, 5, 1, 9, 15, 19,
            21, 33, 78, 93, 10);
        System.out.println(Functions.myMap(numbers, x -> {
            int y = 100;
            int z = 10;
            return y + z + x;
        }));
    }

    @Test
    public void testMethodReferenceAnInstance() {
        List<Integer> numbers = Arrays.asList(2, 4, 5, 1, 9, 15, 19,
            21, 33, 78, 93, 10);
        TaxRate taxRate2016 = new TaxRate(2016, .085);
        System.out.println(Functions.myMap(numbers, taxRate2016::apply));
    }

    @Test
    public void testMethodReferenceANewType() {
        List<Integer> numbers = Arrays.asList(2, 4, 5, 1, 9, 15, 19,
            21, 33, 78, 93, 10);
        System.out.println(Functions.myMap(numbers, Double::new));
    }

    @Test
    public void testMyGenerate() {
        List<LocalDateTime> localDateTimes =
            Functions.myGenerate(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //Ignore the exception
                }

                return LocalDateTime.now();
            }, 10);
        System.out.println(localDateTimes);
    }

    @Test
    public void testLambdasWithRunnable() {
        System.out.format("%s: %s%n",
            Thread.currentThread().getName(),
            "Hello from main thread");
        Thread t = new Thread(() -> {
            String threadName =
                Thread.currentThread().getName();
            System.out.format("%s: %s%n",
                threadName,
                "Hello from another thread");
        });
        t.start();
    }

    public MyPredicate<String> stringHasSizeOf(final int length) {
        return item -> item.length() == length;
    }

    @Test
    public void testClosuresAvoidRepeats() {
        List<String> names = Arrays.asList("Foo", "Ramen", "Naan", "Ravioli");
        System.out.println(Functions.myFilter(names, stringHasSizeOf(4)));
        System.out.println(Functions.myFilter(names, stringHasSizeOf(2)));
    }

    @Test
    public void testOptionalForTruth() {
        Optional<String> middleName1 = Optional.of("Mahesh");
        Optional<String> middleName2 = Optional.empty();

        String result1 = middleName1.orElseGet(() -> "No name found");
        String result2 = middleName2.orElseGet(() -> "No name found");

        assertEquals("Mahesh", result1);
        assertEquals("No name found", result2);
    }
}



