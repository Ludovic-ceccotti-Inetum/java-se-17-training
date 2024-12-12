package io.spring.training.boot.chapter7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

class Chapter7ApplicationTests {

    @Test
    void testInnerInstantiation() {
        var outer = new Outer();
        var inner = outer.new Inner();
        var RandomInner = new Outer.RandomInner();

        Outer.Inner outerInner = new Outer().new Inner();
        assertEquals("Inner!",inner.show()); // this.name will refer to the closest fieldname
    }

    @Test
    void testBuilderPatter() {
        Tractor first = new Tractor.Builder().cost(100500D).name("John Deer").builddate(new Date()).build();
        System.out.println(first.toString());
    }


    class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("I'm running...");
        }
    }

    abstract class MyWalkable implements Runnable {
        String message;
        public MyWalkable(String message) {this.message = message;}
    }


    @Test
    void testAnonymousClass() {
        MyRunnable runnable = new MyRunnable();
        runnable.run();
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm running too...");
            }
        };
        runnable2.run();
        Runnable runnable3 = new MyWalkable("I prefer walking...") {
            @Override
            public void run() {
                System.out.println(message);
            }
        };
        runnable3.run();
    }
}
