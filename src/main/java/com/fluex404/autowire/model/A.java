package com.fluex404.autowire.model;

public class A {
    B b;
    A(B b){
        System.out.println("a is created");
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    void print() {
        System.out.println("Hallo a");
    }
    public void display(){
        b.print();
        print();
    }
}
