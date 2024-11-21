package io.spring.training.boot.chapter4;

import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class Chapter4ApplicationTests {

    @Test
    void testSimpleWhile() {
        int i = 0;

        while (i < 4) {
            System.out.println("i is: " + i);
            i++;
        }
        assertEquals(4, i);
    }

    @Test
    public void testDoWhile() {
        int i = 0;
        do {
            System.out.println("i is: " + i);
            i++;
        } while (i < 4);

        assertEquals(4, i);
    }

    @Test
    public void testForLoop() {
        int j = 0;
        for (int i = 0; i < 3; i++) {
            j += 1;
            System.out.println("j is: " + j + " i is: " + i);
        }
        assertEquals(3, j);
    }

    @Test
    public void testForLooMultipleDeclarations() {
        for (int x = 0, y = 2, z[] = {1, 2, 3}; x < 3; x++, y--, System.out.println()) {
            System.out.printf("x=%d, y=%d, z=[%2$d]", x, y, z[y]);
        }
    }

    @Test
    void testForEachLoop() {
        List<String> names = Arrays.asList("Betty", "Cindy", "Brittany");
        for (String name : names) {
            System.out.println("name: " + name);
        }
    }

    @Test
    @Disabled("will take too much time")
    public void testQuickQuestion() {
        int x = 0;
        do {
            System.out.println("x is: " + x);
            x++;
        } while (x != 0);
        System.out.println("done");
    }
    // Not valid because variable declaration has two differents types
  /*  public void testInvalidForLoop() {
        for(int i = 0, String s = "hello"; i < 3; i++, s +=s){
            System.out.println(s);
        }
    }*/

    @Test
    void testQuickQuestion2() {
        var names = List.of("Betty", "Cindy", "Brittany");
        for (String name : names) {
            int index = names.indexOf(name) + 1;
            System.out.println(index + " : " + name);
        }
    }

    @Test
    void testContinue() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) continue;
            System.out.println("i is: " + i);
        }
    }
    // Not valid because ++i statement will not be reached due to continue instruction
   /* @Test
    void testWrongContinue() {
        for(int i = 0; i < 3; i++) {
            System.out.println(i++);
            continue;
            ++i;
        }
    } */

    @Test
    void testContinuelabel() {
        outer:
        for (int x = 0; x < 5; System.out.println(x), x++) {
            for (int y = 0; y < 5; y++) {
                if (x == y) continue outer; // ignore inner loop
                System.out.printf("x=%d, y=%d : ", x, y);
            }
        }
    }

    @Test
    public void testQuickQuestion3() {
        outer:
        for (int i = 0; i < 4; i++) {
            inner:
            for (int j = 0; j < 4; j++) {
                //if(i == j)  continue outer;
                if (i == j) break inner;
                System.out.println(i + ", " + j + " - ");
            }
        }
    }

    @Test
    void testIfFalse() {
        String word;
        if(false)
            word = "Not so";
        else
            word = "Seems so";
        assertEquals("Seems so", word);
    }

    @Test
    public void testArrowSwitch() {
        int x = 99;
        switch(x) {
            case 99 -> System.out.println("ninety-nine"); // can be written 97,98,97 -> ....
            case 100 -> System.out.println("one hundred");
            //case 101 -> :   not valid
            case 102 -> {} // valid but does nothing
            default -> System.out.println("other");
        }
    }

    @Test
    void testSwitchWithExpressionValue() {
        Function<Integer,String> intToString = x -> {
            var res = switch (x) {
                case 0 -> "Zero"; //valid since it returns a value
                default -> "Other"; // must be present to cover all possible values
            };
            return res;
        };

        assertEquals("Zero", intToString.apply(0));
        assertEquals("Other", intToString.apply(1));
    }

    @Test
    void testYieldSwitch() {
        int x = 0;
        var res = switch (x) {
            case 0 -> {
                System.out.println("calculate for zero");
                yield "Zero"; // return is not a valid keyword in an arrow switch block
            }
           // case 22 -> yield "tenty-two"; yield is not allowed outside of blocks
            default -> throw new IllegalStateException("Unexpected value: " + x);
        };
        assertEquals("Zero", res);
    }
}
