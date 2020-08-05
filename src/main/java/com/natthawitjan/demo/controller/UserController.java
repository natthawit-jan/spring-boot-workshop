package com.natthawitjan.demo.controller;

import com.natthawitjan.demo.pojo.User;
import com.natthawitjan.demo.pojo.UserResponseWithPage;
import com.natthawitjan.demo.pojo.UsersResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("users")
    public UserResponseWithPage getAllUsers(
            @RequestParam(defaultValue = "1") String page,
            @RequestParam(defaultValue = "10", name = "item_per_page") String itemPerPage) {
        int numberOfItems = Integer.parseInt(itemPerPage);
        int pageNumber = Integer.parseInt(page);
        List<UsersResponse> usersResponses = new ArrayList<>();
        for (int i = 0; i < numberOfItems; i++)
            usersResponses.add(new UsersResponse(i + 1, String.format("User %d", i + 1)));
        return new UserResponseWithPage(pageNumber, usersResponses);

    }


}
