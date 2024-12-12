package io.spring.training.boot.chapter8;

public class Receiver {
    String word = "Receiver";

    public void doStuff(Receiver this) {
        System.out.println(this.getClass().getSimpleName() + ".doStuff() " + word);
    }

    public void doStuff(Receiver this, String stuff) {}
}
