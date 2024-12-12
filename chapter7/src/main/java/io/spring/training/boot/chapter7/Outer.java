package io.spring.training.boot.chapter7;

public class Outer {
    private int a = 10;
    private String name = "Outer!";
    private boolean outer = true;

    class Inner {
        private int b = 10;
        private String name = "Inner!";

        public Inner() {
            System.out.println("Inner!");
        }

        public String show() {
            return this.name;
        }
    }

    static class RandomInner {}
}
