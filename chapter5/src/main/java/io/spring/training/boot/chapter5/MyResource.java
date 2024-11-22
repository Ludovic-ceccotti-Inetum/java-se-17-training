package io.spring.training.boot.chapter5;

public class MyResource implements AutoCloseable {

    private static int nextId = 0;
    private final int id = nextId++;
     {
        System.out.println("MyResource: " + id);
    }

    @Override
    public void close() throws Exception {
        System.out.println("close MyResource" + " : " + this.id);
    }
}
