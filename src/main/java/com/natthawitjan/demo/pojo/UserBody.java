package com.natthawitjan.demo.pojo;


public class UserBody {
    private final String name;
    private final int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public UserBody(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
