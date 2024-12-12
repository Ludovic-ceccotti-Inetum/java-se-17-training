package io.spring.training.boot.chapter8;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class Chapter8ApplicationTests {

    static void adder(Integer i) {
        i+= 1;
    }

    static void adder(StringBuilder s) {
        s.append(1);
    }

    @Test
    void testStaticInstanceField() {

        Stat s1 = new Stat();
        Stat s2 = new Stat();
        s1.x++;
        s2.x++;
        s2.x++;
        assert s1.x == 102;
    }

    @Test
    void testInstanceInheritanceField() {
        Child c1 = new Child();
        assert c1.go() == 100;
    }

    @Test
    void testStaticMethod() {
        Integer x = 1; //refrence to an object in memory
        adder(x);
        assert x == 1; //still one because adder(x) has created another Integer object and x still point to the first obkect in memory
    }

    @Test
    void testStaticMethod2() {
        StringBuilder s = new StringBuilder("1");
        adder(s); // mutate an existing object
        assert s.toString().equals("11");
    }

    @Test
    void testRecordCompactConstructor() {
        MyRecord myRecord1 = new MyRecord(10);
        try {
            var data = -1;
            MyRecord myRecord2 = new MyRecord(data);
        } catch (IllegalArgumentException e) {
            System.out.println("Cannot create record: " + e.getMessage());
        }
        assert myRecord1.data() == 10;
    }
}
