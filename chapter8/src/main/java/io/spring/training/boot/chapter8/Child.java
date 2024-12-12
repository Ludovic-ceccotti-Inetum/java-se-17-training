package io.spring.training.boot.chapter8;

public class Child extends Parent {

    public int x = 200;

    public int go() {
        System.out.println("Instance field version of x is: " + x);
        System.out.println("Parent s version of x is : " + super.x);
        Parent p = this;
        System.out.println("p.x gives: " + p.x);
        return p.x;
    }
}
