package com.evolutionnext.textblocks;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class TextBlocksTest {

    @Test
    void testTextBlockStandard() {
        var lyrics = """
            I see trees of green,
            red roses too,
            I see them bloom
            For me and you
            And I think to myself
            What a wonderful world""";

        Map<Character, List<String>> map =
            Arrays.stream(lyrics.split("\n"))
                  .flatMap(s -> Arrays.stream(s.split(" ")))
                  .collect(Collectors.groupingBy(s -> Character.toLowerCase(s.charAt(0))));

        assertThat(map).containsValues(List.of("red", "roses"));
    }

    @Test
    void testTextBlockWithFormat() {
        var statement = """
            The tickets are $%2.2f which is a %%%d increase
            Be sure to get the tickets before %3$tA, %3$tB %3$te of %3$tY""";
        System.out.format(statement, 30.0, 10, LocalDate.of(2020, 7, 3));
    }
}
