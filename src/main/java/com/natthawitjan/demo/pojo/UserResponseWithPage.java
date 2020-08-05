package com.natthawitjan.demo.pojo;

import java.util.List;

public class UserResponseWithPage {

    private int page;
    private List<UsersResponse> usersResponse;


    public List<UsersResponse> getUsersResponse() {
        return usersResponse;
    }

    public void setUsersResponse(List<UsersResponse> usersResponse) {
        this.usersResponse = usersResponse;
    }


    @Override
    public String toString() {
        return "UserResponseWithPage{" +
                "usersResponse=" + usersResponse +
                ", page=" + page +
                '}';
    }


    public int getPage() {
        return page;
    }

    public UserResponseWithPage(int page, List<UsersResponse> usersResponse) {
        this.page = page;
        this.usersResponse = usersResponse;
    }

    public void setPage(int page) {
        this.page = page;
    }

}

