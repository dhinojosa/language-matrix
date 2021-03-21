package com.xyzcorp.lambdavarinfer;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaVarInferTest {

    @Test
    void testLambdaVarInfer() {
        var collect = List.of(1, 2, 3, 4)
                          .stream()
                          .map((@NotNull var integer) -> integer + "!")
                          .collect(Collectors.joining("\n"));
        assertThat(collect).isEqualTo("""
            1!
            2!
            3!
            4!""");
    }
}
