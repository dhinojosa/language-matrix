package com.evolutionnext.optionals;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionalsTest {

    @Test
    public void testOptionalEmpty() {
        Optional<Integer> middleName = Optional.empty();
        assertThat(middleName).isEmpty();
    }

    @Test
    public void testOptionalNonEmpty() {
        Optional<String> middleName = Optional.of("Chandra");
        assertThat(middleName).isNotEmpty();
        assertThat(middleName).contains("Chandra");
    }

    @Test
    public void testOptionalFromSomethingPossiblyNull() {
        String possibleNull = getSomethingRandomlyNull();
        Optional<String> optional = Optional.ofNullable(possibleNull);
        if (possibleNull == null) assertThat(optional.isPresent()).isFalse();
        else assertThat(optional.isPresent()).isTrue();
    }

    private String getSomethingRandomlyNull() {
        var random = new java.util.Random();
        if (random.nextBoolean()) {
            return "Foo";
        } else {
            return null;
        }
    }

    @Test
    public void testGettingTheValueAndLucky() {
        Optional<Long> optionalLong = Optional.of(40L);
        assertThat(optionalLong.get()).isEqualTo(40L);
    }

    @Test
    public void testGettingTheValueTheBadWay() {
        Optional<Long> optionalLong = Optional.empty();
        assertThatThrownBy(optionalLong::get).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    public void testGettingTheValueTheGoodWayUsingGetOrElse() {
        Optional<Long> optionalLong = Optional.empty();
        Long result = optionalLong.orElse(-1L);
        assertThat(result).isEqualTo(-1);
    }

    private Long getDefaultAverage() {
        return 30L;
    }

    @Test
    public void testGettingTheValueTheGoodWayUsingOrElseGet() {
        Optional<Long> optionalLong = Optional.of(40L);
        Long result = optionalLong.orElseGet(this::getDefaultAverage);
        assertThat(result).isEqualTo(40L);
    }

    @Test
    public void testGettingTheValueWithIfPresentOrElse() {
        Optional<Long> optionalLong = Optional.of(40L);
        optionalLong
            .ifPresentOrElse(
                x -> assertEquals(40L, x),
                () -> System.out.println("Not good"));
    }

    @Test
    public void testOptionalWithMap() {
        Optional<Integer> i = Optional.of(40);
        Optional<Integer> result = i.map(a -> a * 20);
        result.ifPresentOrElse(
             a -> assertThat(a).isEqualTo(800),
             () -> fail("It did not pass"));
    }

    @Test
    public void testOptionalWithFlatMap() {
        Optional<Integer> i = Optional.of(40);
        Optional<Integer> j = Optional.of(90);
        Optional<Integer> result = i.flatMap(a -> j.map(b -> a * b));

        result.ifPresentOrElse(
             a -> assertThat(a).isEqualTo(3600),
             () -> fail("It did not pass"));
    }
}
