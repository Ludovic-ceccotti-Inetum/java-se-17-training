package com.example.chapter2;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

public class Chapter2Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(Chapter2Test.class);

    @Test
    public void testImmutability() {
        String h = "hello";
        h.toUpperCase();
        assertFalse(h.equals("HELLO")); // false because s.toUppercase() does not actually change s
        h = h.toUpperCase();
        assertEquals("HELLO",h); // true because h is reassigned
    }

    @Test
    public void testMethods() {
        String h = "hello";
        char first = h.charAt(0);
        assertEquals('h',first);
        String sub = h.substring(2,4);
        LOGGER.info(() -> sub);
        assertEquals("ll",sub);
    }

    @Test
    public void testStringmethods() {
        // test String pool
        String s1 = "holà";
        String s2 = "holà";
        var s3 = "ho";
        var s4 = s3 + "là";
        s3 = s3.concat("là");
        s4 = s4.intern();
        assertTrue(s1 == s2);
        assertFalse(s3 == s1); // false because it is created from "ho" String object
        assertTrue(s1 == s4); // true because s4 in in the String pool and find anoter "holà" object

        String ini = "init";
        assertTrue(ini.endsWith("it"));
        assertFalse(ini.isBlank());
        assertTrue(new String().isBlank());
        assertEquals("bien!", "  bien!  ".trim());
    }

    @Test
    public void testStringCreationMethods() {
        String s1 = new String("salut");
        String s2 = s1.concat("!");
        String s3 = String.copyValueOf(s2.toCharArray());
        assertEquals(s2,s3);
        var s4 = s2.replace('!','?');
        assertEquals("salut?",s4);
        String s5 = String.valueOf(95);
        assertEquals("95",s5);
    }

    @Test
    void testTextBlock() {
        // opening triple quotes must be follwed by a new line
        final String js = """
                const x = 10;
                console.log(x)
                """;
        LOGGER.info(() -> js);
        assertNotNull(js);
        //escape double quotes
        final String quote = """
                ""Coucou toi!""
                """;
        LOGGER.info(() -> quote);
        assertNotNull(quote);
    }
}
