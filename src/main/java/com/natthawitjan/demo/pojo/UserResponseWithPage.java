package com.natthawitjan.demo.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"page", "items_requested_counts", "actual_counts", "users"})
public class UserResponseWithPage {

    private int page;
    @JsonProperty("items_requested_counts")
    private int itemsCounts;
    @JsonProperty("users")
    private List<UsersResponse> usersResponse;
    @JsonProperty("actual_counts")
    private int actualCounts;

    public UserResponseWithPage(int page, int itemsCounts, List<UsersResponse> usersResponse, int actualCounts) {
        this.page = page;
        this.itemsCounts = itemsCounts;
        this.usersResponse = usersResponse;
        this.actualCounts = actualCounts;
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

    public List<UsersResponse> getUsersResponse() {
        return usersResponse;
    }

    public void setUsersResponse(List<UsersResponse> usersResponse) {
        this.usersResponse = usersResponse;
    }

    public int getActualCounts() {
        return actualCounts;
    }

    public void setActualCounts(int actualCounts) {
        this.actualCounts = actualCounts;
    }
}

