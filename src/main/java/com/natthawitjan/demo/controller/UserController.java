package com.natthawitjan.demo.controller;

import com.natthawitjan.demo.pojo.User;
import com.natthawitjan.demo.pojo.UsersResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class UserController {

    @GetMapping({"users", "users/{id}"})
    public List<UsersResponse> getAllUsers(@PathVariable(required = false) Integer id) {
        return (id == null) ? Arrays.asList(
                new UsersResponse(1, "User 1"),
                new UsersResponse(2, "User 2")
        ) : Collections.singletonList(new UsersResponse(id, String.format("User %d", id)));

    }


}
