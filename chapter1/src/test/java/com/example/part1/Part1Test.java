package com.example.part1;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Part1Test {

    private final static Logger LOGGER = LoggerFactory.getLogger(Part1Test.class);

    @Test
    public void test1() {
        Integer a,b;
        a = 2;
        b = 2;
        assertEquals(0,Integer.compare(b,a));
    }

    @Test
    public void testAliasing() {
        List<String> l1 = new ArrayList<>();
        l1.add("hello");
        List<String> l2 = new ArrayList<>(l1);
        LOGGER.info(l2::toString);
        l1.add("bonjour");
        l2 = l1; // l2 share the same reference to l1 so adding element to l1 will add this element to l2 too
        l1.add("ciao");
        LOGGER.info(l1::toString);
        assertTrue(l2.contains("ciao"));
    }

    @Test
    public void testQuestion1() {
        int i = 0;
        int [] ia = new int[] {0,1,2,3};
        ia[++i] = ia[++i] + ia[i];
        assertTrue(Arrays.toString(ia).equals("[0, 4, 2, 3]"));
    }
}
