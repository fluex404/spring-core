package com.fluex404.ci.model;

public class UserMap {
    private int id;
    String name, email;
    public UserMap(){}

    public UserMap(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return id + " "+ name+ " "+email;
    }
}
