package com.evolutionnext.lambdavarinfer;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaVarInferTest {

    /**
     * If we need to add an annotation directly. In this case,
     * it is the IntelliJ Java Annotations that we are including.
     * Without the var, @NotNull wouldn't have anything really to attach to.
     */
    @Test
    void testLambdaVarInfer() {
        var collect =
            List.of(1, 2, 3, 4)
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
