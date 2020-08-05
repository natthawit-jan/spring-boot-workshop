package com.natthawitjan.demo.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;
@JsonPropertyOrder({"page", "items_count", "users"})
@Data
public class UserResponseWithPage {

    private final int page;
    @JsonProperty("items_count")
    private final int itemsCounts;
    @JsonProperty("users")
    private final List<UsersResponse> usersResponse;

}

