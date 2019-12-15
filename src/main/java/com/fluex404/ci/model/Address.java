package com.fluex404.ci.model;

public class Address{
    private String city;
    private String state;
    private String coutry;

    public Address(String city, String state, String coutry) {
        super();
        this.city = city;
        this.state = state;
        this.coutry = coutry;
    }

    @Override
    public String toString() {
        return city+" "+state+" "+coutry;
    }
}