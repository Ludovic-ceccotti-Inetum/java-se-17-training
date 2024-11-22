package io.spring.training.boot.chapter5;

import org.junit.jupiter.api.Test;

public class TryWithResourceTest {

    //@Test
    public void testTryWithResource() throws Exception {
        try(var mr =new MyResource()) {
            System.out.println("using resource");
        }
    }

}
