package com.natthawitjan.demo.pojo;


public class UsersResponse {

    private final int id;
    private final String name;

    public UsersResponse(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
