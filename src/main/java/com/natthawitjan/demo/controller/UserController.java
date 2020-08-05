package com.natthawitjan.demo.controller;

import com.natthawitjan.demo.pojo.User;
import com.natthawitjan.demo.pojo.UsersResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("users")
    public UsersResponse[] getAllUsers(){
        return new UsersResponse[]{
                new UsersResponse(1, "User 1"),
                new UsersResponse(2, "User 2")
        };
    }


}
