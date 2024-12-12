package io.spring.training.boot.chapter8;

public record MyRecord(int data) {
    // compact constructor
    // cannot access to this
    public MyRecord{
         if(data < 0) throw new IllegalArgumentException(data+" is negative");
     }
}
