package com.example.chapter2;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class StringBuilderTest {

    @Test
    void testBuilder() {
        StringBuilder sb1 = new StringBuilder(5);
        StringBuilder sb2 = new StringBuilder();
        sb2.setLength(5);

        StringBuilder sb3 = new StringBuilder();
        sb3.ensureCapacity(5);
        System.out.println(sb1.capacity());
    }
}
