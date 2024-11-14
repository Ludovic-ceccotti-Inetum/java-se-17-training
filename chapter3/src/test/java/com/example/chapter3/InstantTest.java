package com.example.chapter3;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

public class InstantTest {

    @Test
    void testInstant() {
        var periodOneYear = Period.ofYears(1);
        var periodOneMonth = Period.ofMonths(1);
        var feb20= ZonedDateTime.of(2020,2,1,12,15,30,0, ZoneId.of("GMT"));
        var feb21 = feb20.plus(periodOneYear);
        var mar20 = feb20.plus(periodOneMonth);

        var feb20Instant = feb20.toInstant();
        // duration between two instants
        System.out.println(feb20Instant.until(mar20, ChronoUnit.DAYS));
        System.out.println(feb21.truncatedTo(ChronoUnit.HOURS));
        assertEquals(Month.MARCH, mar20.getMonth());
    }

    @Test
    void testDeepDive() throws InterruptedException {
        var instant1 = Instant.now();
        Thread.sleep(10000);
        var instant2 = Instant.now();
        var toMinutes1 = instant1.truncatedTo(ChronoUnit.MINUTES);
        var toMinutes2 = instant2.truncatedTo(ChronoUnit.MINUTES);
        assertEquals(-1,instant1.compareTo(instant2));
        assertEquals(-1,toMinutes1.compareTo(toMinutes2));
    }
}
