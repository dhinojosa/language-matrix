package com.evolutionnext.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DurationPeriodTest {

    @Test
    void testHourBetweenTwoLocalTime() {
        System.out.println(ChronoUnit.HOURS.between(LocalTime.NOON,
            LocalTime.of(18, 13, 40)));
    }

    @Test
    void testDaysBetweenTwoLocalDays() {
        System.out.println(ChronoUnit.DAYS.between(LocalDate.of(2012, 2, 12),
            LocalDate.of(2012, 6, 30)));
    }

    @Test
    void testHoursBetweenTwoLocalDateTime() {
        System.out.println(ChronoUnit.HOURS.between(LocalDateTime.of(2012, 2, 12, 13, 0, 0),
            LocalDateTime.of(2012, 6, 30, 16, 11, 12)));
    }

    @Test
    void testDurationBetweenTwoTimes() {
        Duration between = Duration.between(LocalTime.of(13, 10, 11),
            LocalTime.of(16, 34, 33));

        System.out.println(between);
        System.out.println(between.getSeconds());
        System.out.println(between.getNano());
        System.out.println(between.toMinutes());
        System.out.println(between.toMinutesPart());
    }

    @Test
    void testPeriodBetweenTwoTimes() {
        LocalDate now = LocalDate.now();
        Period between = Period.between(now,
            LocalDate.of(now.getYear(), Month.DECEMBER, 25));
        System.out.println(between);
        System.out.println(now);
    }
}
