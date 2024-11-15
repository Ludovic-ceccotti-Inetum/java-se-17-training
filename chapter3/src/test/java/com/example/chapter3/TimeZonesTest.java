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

    @Test
    void testFlight() {
        var date = LocalDate.now();
        var time = LocalTime.of(8,0,0,0);
        var takeOff = ZonedDateTime.of(date,time,ZoneId.of("America/New_York"));
        var arrival = takeOff.plus(Duration.ofHours(8)).withZoneSameInstant(ZoneId.of("Europe/Madrid"));
        System.out.println(arrival);
        assertEquals(22,arrival.getHour());
    }

    @Test
    public void testFlightZoneDayChange() {
        var tokyo = ZoneId.of("Asia/Tokyo");
        var hawai = ZoneId.of("Pacific/Honolulu");
        final LocalTime takeOffTime = LocalTime.of(8,0,0,0);
        final ZonedDateTime takeOff = ZonedDateTime.of(LocalDate.now(),takeOffTime,tokyo);
        var arrival = takeOff.plusHours(8).withZoneSameInstant(hawai).toLocalDateTime();
        System.out.println(arrival);
        assertEquals(takeOff.getDayOfMonth() -1,arrival.getDayOfMonth());

    }
}
