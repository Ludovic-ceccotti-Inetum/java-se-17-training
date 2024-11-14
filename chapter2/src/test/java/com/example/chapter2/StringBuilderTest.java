package com.example.chapter2;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import static org.junit.jupiter.api.Assertions.*;

public class StringBuilderTest {

    @Test
    void testLengthBuilder() {
        StringBuilder sb1 = new StringBuilder(5);
        StringBuilder sb2 = new StringBuilder();
        sb2.setLength(5);

        StringBuilder sb3 = new StringBuilder();
        sb3.ensureCapacity(5);
        System.out.println(sb1.capacity());
    }

    @Test
    void testBuilderTextManipulation() {
        var builder1 = new StringBuilder();
        var builder2 = new StringBuilder();

        builder1.append("Hello");
        builder1.delete(0,3);
        assertEquals("lo", builder1.toString());

        builder2.append("Hello");
        builder2.deleteCharAt(builder2.length()-1);
        assertEquals("Hell", builder2.toString());

        var builder3 = new StringBuilder("Hello");
        assertEquals("olleH", builder3.reverse().toString());

        var builder4 = new StringBuilder("Hello");
        builder4.insert(0,"!");
        assertEquals("!Hello", builder4.toString());

        var builder5 = new StringBuilder("Hello");
        builder5.replace(2,3,"tt");
        builder5.deleteCharAt(builder5.length()-2);
        assertEquals("Hetto", builder5.toString());
    }
}
