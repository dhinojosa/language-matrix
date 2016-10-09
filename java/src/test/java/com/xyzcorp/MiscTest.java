package com.xyzcorp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MiscTest {

    @Test
    public void testMiscIdeas() {
        List<Integer> numbers = Arrays.asList(2, 4, 5, 1, 9, 15, 19, 21, 33, 78, 93, 10);
        System.out.println(Functions.myFlatMap(numbers, x -> Arrays.asList(-x, x, x + 1)));

        StringBuffer collect = numbers.stream().collect(StringBuffer::new,
                (stringBuffer, integer) -> stringBuffer.append(integer.toString() + ","),
                StringBuffer::append);

        System.out.println(numbers.stream().map(Integer::toUnsignedString).collect(Collectors.joining(",")));
        System.out.println(IntStream.range(1, 6).reduce((i, j) -> i * j).orElseGet(() -> 0));
    }

    @Test
    public void testLambdaIdea() {
        final Random random = new java.util.Random();

        List<Integer> integers = Functions.myGenerate(new MySupplier<Integer>() {
            @Override
            public Integer get() {
                return random.nextInt(50) + 1;
            }
        }, 10);
    }


}
