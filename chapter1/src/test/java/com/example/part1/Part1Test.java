package com.example.part1;

import org.apache.logging.log4j.core.LoggerContext;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class Part1Test {

    private final static Logger LOGGER = LoggerFactory.getLogger(Part1Test.class);

    @Test
    public void test1() {
        LOGGER.info(() -> "Running test" );
        assertTrue(2 > 1);
    }
}
