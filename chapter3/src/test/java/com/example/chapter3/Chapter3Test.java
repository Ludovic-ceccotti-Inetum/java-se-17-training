package com.example.chapter3;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.UnsupportedTemporalTypeException;

import static org.junit.jupiter.api.Assertions.*;

public class Chapter3Test {

    @Test
    public void testTypes() {
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime nowSomeWhere = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(now);
        System.out.println(nowSomeWhere);

        var duration = Duration.between(now, nowSomeWhere);
        System.out.println(duration);
        System.out.println(Duration.ofMinutes(300));
        System.out.println(Period.of(2024,10,31));
    }

    @Test
    void testOperations() {
        LocalDate localDate = LocalDate.of(2024, 11, 14);
        assertEquals(LocalDate.of(2024, 12, 14), localDate.plusMonths(1));
        var julyDate = localDate.with(ChronoField.MONTH_OF_YEAR, 7);
        assertEquals(localDate.withMonth(7), julyDate);

        var atTime = localDate.atTime(LocalTime.of(4, 6));
        assertEquals(LocalDateTime.class, atTime.getClass());

        assertEquals(LocalDate.of(2024,11,24),localDate.plus(Period.ofDays(10)));
    }

    @Test
    void testInvalidType() {
        // fails at runtime because there is no time element to extract
        assertThrows(DateTimeException.class, () -> LocalDateTime.from(LocalDate.now()));
        assertThrows(UnsupportedTemporalTypeException.class, () -> LocalDate.now().get(ChronoField.HOUR_OF_DAY));
    }

    @Test
    void testMethodSupport() {
        assertTrue(LocalDate.now().isSupported(ChronoField.DAY_OF_YEAR)); // true because local date support days
        assertFalse(LocalDate.now().isSupported(ChronoField.HOUR_OF_DAY)); // time missing in local date
    }
}