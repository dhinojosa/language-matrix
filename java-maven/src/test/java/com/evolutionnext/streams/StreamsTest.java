package com.evolutionnext.streams;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.*;

import static java.util.function.Function.identity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StreamsTest {

    private static Optional<Character> safeCharAt(String s, int index) {
        try {
            return Optional.of(s.charAt(index));
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    /* Creation */
    @Test
    public void createAStreamFromElements() {
        Stream<Integer> integerStream = Stream.of(3, 4, 5);
        List<Integer> result =
            integerStream
                .map(x -> x + 2)
                .collect(Collectors.toList());
        assertThat(result).isEqualTo(List.of(5, 6, 7));
    }

    @Test
    public void testBasicStreamFromList() {
        List<Integer> integers = Arrays.asList(1, 4, 5);
        List<Integer> result =
            integers.stream()
                    .map(x -> x + 1)
                    .collect(Collectors.toList());
        assertEquals(result, Arrays.asList(2, 5, 6));
    }

    @Test
    public void testBasicStreamFromSet() {
        Set<Integer> integers = Set.of(30, 10, 12, 4);
        Set<Integer> result =
            integers.stream()
                    .map(x -> x + 1)
                    .collect(Collectors.toSet());
        assertEquals(result, Set.of(31, 11, 13, 5));
    }

    @Test
    public void testBasicStreamFromSetToList() {
        Set<Integer> integers = Set.of(30, 10, 12, 4);
        List<Integer> result =
            integers.stream()
                    .map(x -> x + 1)
                    .collect(Collectors.toList());
        //System.out.println(result);
        assertThat(result).contains(11, 31, 5, 13);
    }

    @Test
    public void testBasicStreamFromMap() {
        Map<String, String> countriesAndCapitals =
            Map.of("Denmark", "Copenhagen", "China", "Beijing");

        List<String> result = countriesAndCapitals
            .entrySet()
            .stream()
            .map(e -> e.getKey() + "~" + e.getValue())
            .collect(Collectors.toList());

        System.out.println(result);
        assertThat(result).contains("China~Beijing", "Denmark~Copenhagen");
    }

    @Test
    public void testBasicStreamFromArray() {
        String[] stringArray = new String[]{"Foo", "Bar", "Baz", "Bam"};
        Stream<String> stream = Arrays.stream(stringArray);
        List<String> result =
            stream
                .map(x -> x + "!")
                .collect(Collectors.toList());
        assertEquals(result, List.of("Foo!", "Bar!", "Baz!", "Bam!"));
    }


    /* Specialization */
    @Test
    public void testSpecializedIntStream() {
        int result = IntStream.of(30, 12, 50).map(x -> x * 3).sum();
        assertThat(result).isEqualTo(276);
    }

    @Test
    public void testSpecializedLongStream() {
        long result = LongStream.of(30, 12, 50).map(x -> x * 3).sum();
        assertThat(result).isEqualTo(276L);
    }

    @Test
    public void testSpecializedDoubleStream() {
        double result = DoubleStream.of(30, 12, 50).map(x -> x * 3).sum();
        assertThat(result).isEqualTo(276.0);
    }

    @Test
    public void testSpecializedFromPrimitiveArray() {
        int[] primitiveIntArray = new int[]{1, 3, 4, 5};
        IntStream stream = Arrays.stream(primitiveIntArray);
        assertThat(stream.sum()).isEqualTo(13);
    }

    @Test
    public void testSpecializedLongStreamWithBuilderAndAdd() {
        LongStream longStream =
            LongStream.builder().add(40L).add(10L).add(20L).build();
        longStream
            .average()
            .ifPresentOrElse(avg -> System.out.printf("Average: %2.2f", avg),
                () -> System.out.println("No Average"));
    }

    @Test
    public void testSpecializedLongStreamWithBuilderAndAccept() {
        LongStream.Builder builder =
            LongStream.builder().add(40L).add(10L).add(20L);
        builder.accept(31L);
        builder.accept(41L);
        builder.accept(51L);
        builder.accept(61L);
        LongStream longStream = builder.build();
        String result =
            longStream
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        assertThat(result).isEqualTo("40, 10, 20, 31, 41, 51, 61");
    }

    @Test
    public void testSpecializedIntStreamRange() {
        int result = IntStream.range(0, 5).sum();
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void testSpecializedLongStreamRangeClosed() {
        long result = LongStream.rangeClosed(0, 5).sum();
        assertThat(result).isEqualTo(15);
    }

    /* Conversion */
    @Test
    public void testFromSpecializedStreamToGeneralStream() {
        IntStream stream = IntStream.range(0, 5);
        List<Integer> result =
            stream
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        assertThat(result).containsExactly(0, 1, 2, 3, 4);
    }

    @Test
    public void testFromSpecializedStreamToGeneralStreamWithBoxed() {
        IntStream stream = IntStream.range(0, 5);
        List<Integer> result =
            stream
                .boxed()
                .collect(Collectors.toList());
        assertThat(result).containsExactly(0, 1, 2, 3, 4);
    }

    @Test
    public void testFromGeneralStreamToSpecializedIntStream() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        IntStream intStream = integerStream.mapToInt(x -> x);
        int result = intStream.sum();
        assertThat(result).isEqualTo(15);
    }

    @Test
    public void testFromGeneralStreamToSpecializedLongStream() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        LongStream longStream = integerStream.mapToLong(x -> x);
        long result = longStream.sum();
        assertThat(result).isEqualTo(15L);
    }

    @Test
    public void testFromGeneralStreamToSpecializedDoubleStream() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        DoubleStream doubleStream = integerStream.mapToDouble(x -> x);
        double result = doubleStream.sum();
        assertThat(result).isEqualTo(15.0);
    }

    /* Operations */

    @Test
    public void testMap() {
        List<Integer> result = Stream
            .of(1, 2, 3, 4)
            .map(x -> x * 2)
            .collect(Collectors.toList());
        assertThat(result).isEqualTo(List.of(2, 4, 6, 8));
    }

    @Test
    public void testFilter() {
        List<Integer> result = Stream
            .of(1, 2, 3, 4)
            .filter(x -> x % 2 == 0)
            .collect(Collectors.toList());
        assertThat(result).isEqualTo(List.of(2, 4));
    }

    @Test
    public void testFlatMap() {
        Stream<Integer> stream =
            Stream.of(1, 2, 3, 4)
                  .flatMap(x -> Stream.of(-x, x, x + 2));
        List<Integer> result =
            stream.collect(Collectors.toList());
        assertThat(result)
            .containsExactly(-1, 1, 3, -2, 2, 4, -3, 3, 5, -4, 4, 6);
    }

    @Test
    public void testFlatMapAsCleaner() {
        var result =
            Stream.of("Apple", "Orange", "", "Banana", "Tomato", "Grapes", "")
                  .map(s -> safeCharAt(s, 0))
                  .flatMap(Optional::stream)
                  .collect(Collectors.toList());
        assertThat(result).isEqualTo(List.of('A', 'O', 'B', 'T', 'G'));
    }


    @Test
    public void testStreamWithPeek() {
        List<Integer> result =
            Stream.of(1, 2, 3, 4, 5)
                  .map(x -> x + 1)
                  .peek(System.out::println)
                  .filter(x -> x % 2 == 0)
                  .collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void testLimit() {
        List<Integer> result =
            IntStream.range(0, 20).boxed().limit(5).collect(Collectors.toList());
        assertThat(result).isEqualTo(List.of(0, 1, 2, 3, 4));
    }

    @Test
    public void testSkip() {
        List<Integer> result =
            IntStream.range(0, 20).boxed().skip(10).collect(Collectors.toList());
        assertThat(result).isEqualTo(List.of(10, 11, 12, 13, 14, 15, 16, 17,
            18, 19));
    }

    @Test
    public void testDistinct() {
        List<String> distinct = Stream
            .of("Right", "Left", "Right", "Right")
            .distinct()
            .collect(Collectors.toList());
        assertThat(distinct).containsOnly("Left", "Right");
    }

    @Test
    public void testSortedWithComparator() {
        Stream<String> stream =
            Stream.of("Apple", "Orange", "Banana", "Tomato", "Grapes", "Kiwi");

        List<String> list =
            stream
                .sorted((o1, o2) -> Integer.compare(o1.length(), o2.length()))
                .collect(Collectors.toList());

        assertThat(list)
            .containsExactly("Kiwi", "Apple", "Orange", "Banana", "Tomato",
                "Grapes");
    }

    @Test
    public void testSortedWithComparatorUtility() {
        Stream<String> stream =
            Stream.of("Apple", "Orange", "Banana", "Tomato", "Grapes", "Kiwi");

        List<String> list = stream
            .sorted(Comparator.comparingInt(String::length))
            .collect(Collectors.toList());

        System.out.println(list);
    }

    @Test
    public void testSortedWithNestedComparators() {
        Stream<String> stream =
            Stream.of("Apple", "Orange", "Banana", "Tomato", "Grapes", "Plum"
                , "Kiwi");
        System.out.println(stream
            .sorted(Comparator
                .comparing(String::length)
                .thenComparing(identity()))
            .collect(Collectors.toList()));
    }


    @Test
    public void testGeneralStreamCount() {
        long count = Stream.of(12, 4, 10).count();
        assertThat(count).isEqualTo(3);
    }

    /**
     * Terminal Operators
     **/
    @Test
    public void testSpecializedStreamCount() {
        long count = IntStream.range(0, 20).count();
        assertThat(count).isEqualTo(20);
    }


    @Test
    public void testReduceWithoutASeed() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
        Optional<Integer> reduction = stream.reduce((total, next) -> {
            System.out.format("total: %d, next: %d\n", total, next);
            return total + next;
        });
        assertThat(reduction).contains(21);
    }

    @Test
    public void testReduceWithASeed() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
        Integer reduction = stream.reduce(0, (total, next) -> {
            System.out.format("total: %d, next: %d\n", total, next);
            return total + next;
        });
        assertThat(reduction).isEqualTo(21);
    }


    @Test
    public void testFindFirstSuccessful() {
        Optional<Integer> first = Stream.of(1, 2, 4, 5)
                                        .findFirst();
        first
            .ifPresentOrElse(x -> assertThat(x).isEqualTo(1), () -> fail(
                "Unexpected"));
    }

    @Test
    public void testFindFirstUnsuccessful() {
        Optional<Integer> first = Stream.<Integer>empty()
            .findFirst();
        first
            .ifPresentOrElse(x -> fail("Unexpected"), () -> assertTrue(true));
    }

    @Test
    public void testSummaryStatistics() {
        IntStream intStream = IntStream.of(12, 19, 40, 60, 100, 200, 15, 0, 3);
        System.out.println(intStream.summaryStatistics());
    }

    /* Infinite Streams */
    @Test
    public void testIterate() {
        Stream<Integer> iterate = Stream.iterate(0,
            integer -> integer + 3);
        List<Integer> result = iterate.limit(5).collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void testIterateWithPredicate() {
        List<Integer> result = Stream.iterate(0, x -> x <= 5,
            integer -> integer + 1).collect(Collectors.toList());
        System.out.println(result);
        assertThat(result).isEqualTo(List.of(0,1,2,3,4,5));
    }

    @Test
    public void testGenerate() {
        List<LocalDateTime> result =
            Stream.generate(LocalDateTime::now)
                  .flatMap(x -> Stream.of(x, x.plusYears(10)))
                  .limit(5)
                  .collect(Collectors.toList());
        System.out.println("stream1 = " + result);
    }

    @Test
    public void testSpecializedDoubleStreamIterate() {
        List<Double> result = DoubleStream
            .iterate(1.0, x -> x + .05)
            .limit(3)
            .boxed().collect(Collectors.toList());
        assertThat(result).isEqualTo(List.of(1.0, 1.05, 1.10));
    }

    /* Common Collectors */
    @Test
    public void testGroupingBy() {
        IntStream stream = IntStream.range(0, 10);
        Map<Boolean, List<Integer>> groups =
            stream.boxed()
                  .collect(Collectors.groupingBy(i -> i % 2 == 0));
        System.out.println(groups);
        assertThat(groups)
            .containsKeys(false, true)
            .containsValues(List.of(1, 3, 5, 7, 9), List.of(0, 2, 4, 6, 8));
    }

    @Test
    public void testPartitioning() {
        Stream<String> stream =
            Stream.of("Apple", "Orange", "Banana", "Tomato", "Grapes");
        Map<Boolean, List<String>> partition = stream.collect
            (Collectors.partitioningBy(s -> "AEIOU"
                .indexOf(s.toUpperCase().charAt(0)) >= 0));
        System.out.println(partition);
        assertThat(partition).containsKeys(false, true)
                             .containsValues(
                                 List.of("Banana", "Tomato", "Grapes"),
                                 List.of("Apple", "Orange"));
    }

    @Test
    public void testJoining() {
        Stream<String> stream =
            Stream.of("Apple", "Orange", "Banana", "Tomato", "Grapes");
        String result = stream.collect(Collectors.joining(", ", "{", "}"));
        assertThat(result).isEqualTo("{Apple, Orange, Banana, Tomato, Grapes}");
    }

    @Test
    public void testToMap() {
        List<Order> orders = createFakeOrders();

        Map<String, Integer> result = orders
            .stream()
            .collect(Collectors
                .toMap(Order::getFirstName,
                    o -> o.getOrderItems()
                          .stream()
                          .mapToInt(OrderItem::getQuantity).sum()));

        System.out.println(result);
    }

    private List<Order> createFakeOrders() {
        var order1 = new Order("Bob", "Hanson", "Redwood City", "CA");
        var orderItems1 = List.of(new OrderItem(2, new Product("Soap", 3),
                order1),
            new OrderItem(5, new Product("Bread", 4), order1),
            new OrderItem(1, new Product("Toothbrush", 9), order1));

        var order2 = new Order("Clara", "Jimenez", "Atlanta", "GA");
        var orderItems2 = List.of(new OrderItem(1, new Product("Brush", 5),
                order2),
            new OrderItem(5, new Product("Milk", 2), order2),
            new OrderItem(1, new Product("Soap", 9), order2),
            new OrderItem(2, new Product("Notebooks", 4), order2),
            new OrderItem(3, new Product("Pens", 2), order2));

        var order3 = new Order("Pratik", "Agarwal", "Los Angeles", "CA");
        var orderItems3 = List.of(
            new OrderItem(5, new Product("Notebooks", 4), order3),
            new OrderItem(5, new Product("Pens", 2), order3),
            new OrderItem(1, new Product("Shampoo", 5), order2),
            new OrderItem(1, new Product("Tofu", 2), order2),
            new OrderItem(1, new Product("Soap", 9), order3));

        return List.of(order1.addOrderItems(orderItems1),
            order2.addOrderItems(orderItems2),
            order3.addOrderItems(orderItems3));
    }

    @Test
    public void testSummingInt() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer result = numbers.stream().map(x -> x + 1)
                                .collect(Collectors.summingInt(x -> x));
        System.out.println(result);
    }

    @Test
    public void testBasicCustomCollector() {
        List<Integer> numbers =
            Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result =
            numbers.stream()
                   .map(x -> x + 1)
                   .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("Ending with the result = " + result);
    }


    /* Parallelization */

    @Test
    public void testParallelCollections() {
        List<Integer> collect =
            IntStream.range(0, 10)
                     .boxed()
                     .parallel()
                     .map(x -> x + 1)
                     .peek(x-> System.out.println("parallel:" + Thread.currentThread().getName()))
                     .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void testBasicCustomParallelCollector() {
        List<Integer> numbers =
            Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result =
            numbers.stream()
                   .parallel()
                   .map(x -> x + 1)
                   .collect(ArrayList::new,
                       ArrayList::add,
                       ArrayList::addAll);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), result);
    }

    @Test
    public void testBasicCustomParallelCollectorVerbose() {
        List<Integer> numbers =
            Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result =
            numbers.stream()
                   .parallel()
                   .map(x -> {
                       System.out.format("%s: map: %s\n",
                           Thread.currentThread().getName(), x);
                       return x + 1;
                   }).collect(
                ArrayList::new,
                (integers, integer) -> {
                    System.out.format("%s: adding integer: %s\n",
                        Thread.currentThread().getName(), integer);
                    integers.add(integer);
                }, (left, right) -> {
                    System.out.format("%s: left = %s\n",
                        Thread.currentThread().getName(), left);
                    System.out.format("%s: right = %s\n",
                        Thread.currentThread().getName(), right);
                    left.addAll(right);
                    System.out.format("%s: combined = %s\n",
                        Thread.currentThread().getName(), left);
                });
        System.out.println("Ending with the result = " + result);
        assertEquals(result, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @Test
    public void testGroupingByConcurrent() {
        IntStream stream = IntStream.range(0, 10);
        Map<Boolean, List<Integer>> groups =
            stream.parallel()
                  .boxed()
                  .collect(Collectors.groupingByConcurrent(i -> i % 3 == 0));
        System.out.println(groups.getClass().getName());
        System.out.println(groups);
    }
}











