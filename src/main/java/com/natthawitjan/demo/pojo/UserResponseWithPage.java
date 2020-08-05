package com.natthawitjan.demo.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
@JsonPropertyOrder({"page", "items_count", "users"})
public class UserResponseWithPage {

    private int page;
    @JsonProperty("items_count")
    private int itemsCounts;
    @JsonProperty("users")
    private List<UsersResponse> usersResponse;

    public UserResponseWithPage(int page, int itemsCounts, List<UsersResponse> usersResponse) {
        this.page = page;
        this.itemsCounts = itemsCounts;
        this.usersResponse = usersResponse;
    }



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


    public void setPage(int page) {
        this.page = page;
    }

    public int getItemsCounts() {
        return itemsCounts;
    }

    public void setItemsCounts(int itemsCounts) {
        this.itemsCounts = itemsCounts;
    }
}

