package com.evolutionnext.datetime;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalQuery;
import java.util.Locale;

public class DatesTest {

    @Test
    public void testInstant() throws Exception {
        Instant instant = Instant.now();
        System.out.println("instant = " + instant);
        System.out.println(instant.getEpochSecond());
        System.out.println(instant.getNano());
    }

    @Test
    public void testChronoUnitAddToInstant() {
        Instant instant = Instant.now();
        var instantPlus19Days = instant.plus(19, ChronoUnit.DAYS);
        System.out.println(instantPlus19Days);
    }

    @Test
    public void testChronoUnitBetween() throws Exception {
        long between = ChronoUnit.DAYS.between
            (Instant.parse("2019-01-05T12:00:00.0Z"),
                Instant.parse("2019-01-01T12:00:00.0Z"));
        System.out.println("between = " + between);
    }

    @Test
    public void testCreateLocalDateWithOf() {
        LocalDate february20th = LocalDate.of(2014,
            Month.FEBRUARY,
            20);
        System.out.println(february20th);
    }

    @Test
    public void testCreateLocalDateWithFrom() {
        LocalDate february20th = LocalDate.of(2014,
            Month.FEBRUARY,
            20);
        System.out.println(LocalDate
            .from(february20th.plus(10, ChronoUnit.DAYS)));
    }

    @Test
    public void testCreateLocalDateWithParse() {
        System.out.println(LocalDate.parse("2014-11-22"));
    }

    @Test
    public void testDaylightSavingChange() {
        LocalDateTime date = LocalDateTime.of(2012, 11, 12, 13, 11, 12);
        date.atZone(ZoneId.of("America/Los_Angeles")); //2012-11-12T13:11:12
        // -08:00[America/Los_Angeles]


        LocalDateTime daylightSavingTime = LocalDateTime.of(2014, 3, 9, 2,
            0, 0, 0);
        daylightSavingTime.atZone(ZoneId.of("America/Denver")); //2014-03
        // -09T03:00-06:00[America/Denver]
    }

    @Test
    public void testStandardTime() {
        LocalDateTime standardTime6 = LocalDateTime.of(2014, 11, 15, 1, 30, 0, 0);
        System.out.println(standardTime6.atZone(ZoneId.of("America/New_York")));
        System.out.println(standardTime6.atZone(ZoneId.of("America/New_York"))
                                        .withEarlierOffsetAtOverlap().toInstant().getEpochSecond());
        System.out.println(standardTime6.atZone(ZoneId.of("America/New_York"))
                                        .withLaterOffsetAtOverlap().toInstant().getEpochSecond());
    }

    @Test
    public void formatLocalDate() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println(dateFormatter.format(LocalDate.now()));
    }

    @Test
    public void testCustomizedFormat() {
        DateTimeFormatter obscurePattern =
            DateTimeFormatter.ofPattern("MMMM dd, yyyy '(In Time Zone: 'VV')'" +
                " q 'Quarter'");
        ZonedDateTime zonedNow = ZonedDateTime.now();

        System.out.println(obscurePattern.format(zonedNow));
    }

    @Test
    public void testFrench() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America" +
            "/Los_Angeles"));

        DateTimeFormatter longDateTimeFormatter =
            DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.FULL)
                .withLocale(new Locale("es", "US"));
        longDateTimeFormatter.getLocale(); //IN
        System.out.println(longDateTimeFormatter.format(zonedDateTime));
    }

    @Test
    public void testShiftingTimeZones() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime tokyoTime = ZonedDateTime.of(localDateTime, ZoneId.of(
            "Asia/Tokyo"));
        System.out.println(tokyoTime);
        System.out.println(tokyoTime.withZoneSameLocal(ZoneId.of("America" +
            "/Los_Angeles")));
        System.out.println(tokyoTime.withZoneSameInstant(ZoneId.of("America" +
            "/Los_Angeles")));
    }


    @Test
    public void testDaysBeforeChristmas() {
        TemporalQuery<Long> daysBeforeChristmas = temporal -> {
            LocalDate localDate = LocalDate.from(temporal);
            long d = ChronoUnit.DAYS.between(localDate,
                LocalDate.of(localDate.getYear(), 4, 15));
            if (d >= 0) return d;
            return ChronoUnit.DAYS.between
                (localDate, LocalDate.of(localDate.getYear() + 1, 12, 25));
        };

        System.out.println(LocalDate.now().query(daysBeforeChristmas)); //364
    }

    @Test
    public void testParsingANonISO8601Format() throws Exception {
        DateTimeFormatter dateFormatter =
            DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println(dateFormatter.parse("Jan 19, 2014",
            LocalDate::from));
    }
}
