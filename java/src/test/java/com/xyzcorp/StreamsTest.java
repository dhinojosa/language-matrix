package com.xyzcorp;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsTest {


    @Test
    public void testBasicStream() {
        List<Integer> strings = Arrays.asList(1, 4, 5, 10, 11, 12, 40, 50);
        strings.stream().map(x -> x + 1).collect(Collectors.toList());
        //Describe the parts
        //1. Create the stream
        //2. Use some functions (immediate operations)
        //3. Reduce
    }

    @Test
    public void testCompleteCollector() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result = numbers.stream().parallel().map(x -> x + 1).collect(
                ArrayList::new,
                (integers, integer) -> {
                    System.out.println("adding integer: " + integer);
                    integers.add(integer);
                }, (left, right) -> {
                    synchronized (numbers) {
                        System.out.println("left = " + left);
                        System.out.println("right = " + right);
                        left.addAll(right);
                        System.out.println("combined = " + left);
                    }
                });
        System.out.println("Ending with the result = " + result);
    }

    @Test
    public void testSum() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer result = numbers.stream().map(x -> x + 1)
                         .collect(Collectors.summingInt(x -> x));
        System.out.println(result);
    }

    @Test
    public void testMin() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Optional<Integer> minimum = numbers.stream().map(x -> x + 1)
                .collect(Collectors.minBy(Integer::compareTo));
        System.out.println(minimum);
    }

    @Test
    public void testMax() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Optional<Integer> minimum = numbers.stream().map(x -> x + 1)
                .collect(Collectors.minBy(Comparator.naturalOrder()));
        System.out.println(minimum);
    }

    @Test
    public void testCreateStreamsUsingOf() {
        Stream<Integer> streamOfInteger = Stream.of(1, 2, 3, 4, 5);
        //int primitive specialization of a stream
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
    }

    @Test
    public void testStreamGetAverageGradesUsingCollector() {
        Stream<Integer> grades = Stream.of(100, 99, 95, 88, 100, 90, 85);
        Double collect = grades.collect(Collectors.averagingInt(x -> x));
        System.out.println(optionalDouble);
    }
    @Test
    public void testStreamGetAverageGrades() {
        IntStream grades = IntStream.of(100, 99, 95, 88, 100, 90, 85);
        OptionalDouble optionalDouble = grades.average();
        System.out.println(optionalDouble);
    }
//
//    @Test
//    public void testIntStreamWithRange() {
//        //The problem with an int range is that you are left to do up your own collect.
//        //This is where boxed() comes in
//        IntStream.range(5, 10).filter(x -> x % 2 == 0).boxed().collect(Collectors.toSet());
//    }
//
//    @Test
//    public void testConvertToIntStream() {
//        Stream<Integer> numbers = Stream.of(100, 33, 22, 400, 30);
//        IntStream intStream = numbers.mapToInt(x -> x);
//        System.out.println(intStream.sum());
//
//    }
//
//    @Test
//    public void testIntStreamSummaryStatistics() {
//        Stream<Integer> numbers = Stream.of(100, 33, 22, 400, 30);
//        IntStream intStream = numbers.mapToInt(x -> x);
//        System.out.println(intStream.summaryStatistics());
//    }
//
//    @Test
//    public void testStreamWithPeek() {
//        //Peek is a side effect intermediate calculation to view the state of the the chain.
//        List<Integer> result = Stream.of(1, 2, 3, 4, 5)
//                .map(x -> x + 1)
//                .peek(System.out::println)
//                .filter(x -> x % 2 == 0)
//                .collect(Collectors.toList());
//        System.out.println(result);
//    }
//
//    @Test
//    public void testDistinct() {
//        List<Integer> result = Stream.of(1, 2, 3, 4, 5, 4, 3, 2, 1)
//                .distinct()
//                .peek(System.out::println)
//                .collect(Collectors.toList());
//
//        System.out.println(result);
//    }
//
//    @Test
//    public void testLimit() {
//        //Lazy
//        Stream<Integer> integerStream = Stream.iterate(0, x -> x + 1); //Goes on forever!
//        List<Integer> result = integerStream.map(x -> x + 4).peek(System.out::println).limit(10).collect(Collectors.toList());
//        System.out.println(result);
//    }
//
//
//    @Test
//    public void testFlatMap() {
//        Stream<Integer> streamStream = Stream.of(1, 2, 3, 4).flatMap(x -> Stream.of(-x, x, x + 2));
//        List<Integer> list = streamStream.collect(Collectors.toCollection(ArrayList::new));
//        System.out.println(list);
//    }
//
//    @Test
//    public void testReduce() {
//        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
//        Optional<Integer> reduction = stream.reduce((total, next) -> {
//            System.out.format("total: %d, next: %d\n", total, next);
//            return total + next;
//        });
//        System.out.println(reduction);
//    }
//
//
//    @Test
//    public void testReduceWithASeed() {
//        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
//        Integer reduction = stream.reduce(0, (total, next) -> {
//            System.out.format("total: %d, next: %d\n", total, next);
//            return total + next;
//        });
//        System.out.println(reduction);
//    }
//
//    @Test
//    public void testSorted() {
//        Stream<String> stream = Stream.of("Apple", "Orange", "Banana", "Tomato", "Grapes");
//        System.out.println(stream.sorted().collect(Collectors.toList()));
//    }
//
//    @Test
//    public void testSortedWithComparator() {
//        Stream<String> stream = Stream.of("Apple", "Orange", "Banana", "Tomato", "Grapes");
//        Comparator<String> stringComparator = Comparator.comparing(String::length).thenComparing((String s) -> s);
//        System.out.println(stream
//                .sorted((string1, string2) -> string1.length() - string2.length())
//                .collect(Collectors.toList()));
//    }
//
//    @Test
//    public void testSortedWithComparatorLevels() {
//        Stream<String> stream = Stream.of("Apple", "Orange", "Banana", "Tomato", "Grapes");
//        Comparator<String> stringComparator = Comparator.comparing(String::length)
//                .thenComparing(Function.identity());
//        System.out.println(stream
//                .sorted(stringComparator)
//                .collect(Collectors.toList()));
//    }
//
//
//    @Test
//    public void testGrouping() {
//        Stream<String> stream = Stream.of("Apple", "Orange", "Banana", "Tomato", "Grapes");
//        Map<Character, List<String>> groups = stream.collect(Collectors.groupingBy(s -> s.charAt(0)));
//        System.out.println(groups);
//    }
//
//    @Test
//    public void testPartitioning() {
//        Stream<String> stream = Stream.of("Apple", "Orange", "Banana", "Tomato", "Grapes");
//        Map<Boolean, List<String>> partition = stream.collect
//                (Collectors.partitioningBy(s -> "AEIOU"
//                        .indexOf(s.toUpperCase().charAt(0)) > 0));
//        System.out.println(partition);
//    }
//
//    @Test
//    public void testJoining() {
//        Stream<String> stream = Stream.of("Apple", "Orange", "Banana", "Tomato", "Grapes");
//        System.out.println(stream.collect(Collectors.joining(", ")));
//    }
//
//
//    @Test
//    public void testJoiningAdvanced() {
//        Stream<String> stream = Stream.of("Apple", "Orange", "Banana", "Tomato", "Grapes");
//        System.out.println(stream.collect(Collectors.joining(", ", "{", "}")));
//    }
//
//    @Test
//    public void testDiscoveringAmerica() {
//        List<String> america = ZoneId.getAvailableZoneIds()
//                .stream().filter(x -> x.startsWith("America"))
//                .map(x -> x.split("/")[1]).distinct()
//                .sorted().collect(Collectors.toList());
//        System.out.println(america);
//    }
//
//    @Test
//    public void testBreakUpAndExplain() {
//        Random random = new Random();
//        ArrayList<Integer> collection = random.ints().parallel().filter(i -> i > 0).limit(40)
//                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//        System.out.println(collection);
//
//
//        DoubleStream.of(120.00, 11.00, 31.00, 12.00, 10.00, 30.00);
//
//        List<Integer> integers = IntStream.of(3, 10, 40, 0, 19).boxed().collect(Collectors.toList());
//        String stringIntegers = IntStream.of(3, 10, 40, 0, 19).boxed().map(Object::toString).collect(Collectors.joining(","));
//
//        System.out.println(stringIntegers);
//    }
}
