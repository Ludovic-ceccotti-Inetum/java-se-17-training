package com.example.chapter3;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TimeZonesTest {

    @Test
    void testTimeZones() {
        Collection<String> timeZones = List.of(TimeZone.getAvailableIDs());
        //timeZones.forEach(System.out::println);
        timeZones.stream().filter(zone -> zone.startsWith("Europe/")).forEach(System.out::println);

        ZoneId.of("Europe/London").getRules().getTransitions().forEach(System.out::println);
    }

    @Test
    void testTransitions() {
        var rules = ZoneId.of("Europe/London").getRules();
        System.out.println(rules.nextTransition(Instant.now()));
        System.out.println(rules.previousTransition(Instant.now()));
    }

    @Test
    void testCreation() {
        var zonedDateTime = ZonedDateTime.of((LocalDateTime) LocalDate.now().adjustInto(LocalDateTime.now()), ZoneId.systemDefault());
        var tokyoTime = ZonedDateTime.of(zonedDateTime.toLocalDateTime(), ZoneId.of("Asia/Tokyo"));
        System.out.println(zonedDateTime);
        assertEquals(ZoneId.systemDefault(), zonedDateTime.getZone());
        Duration gap = Duration.between(tokyoTime, zonedDateTime);
        System.out.println(gap);
        assertEquals(8, gap.toHours());
    }
}
