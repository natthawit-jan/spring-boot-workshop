package com.natthawitjan.demo.controller;

import com.natthawitjan.demo.pojo.UserBody;
import com.natthawitjan.demo.pojo.UserResponseWithPage;
import com.natthawitjan.demo.pojo.UsersResponse;
import com.natthawitjan.demo.repository.User;
import com.natthawitjan.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("users")
    public UserResponseWithPage getAllUsers(
            @RequestParam(defaultValue = "1") String page,
            @RequestParam(defaultValue = "10", name = "item_per_page") String itemPerPage) {
        int numberOfItems = Integer.parseInt(itemPerPage);
        int pageNumber = Integer.parseInt(page);
        List<UsersResponse> usersResponses = new ArrayList<>();
        for (int i = 0; i < numberOfItems; i++)
            usersResponses.add(new UsersResponse(i + 1, String.format("User %d", i + 1)));
        return new UserResponseWithPage(pageNumber, numberOfItems, usersResponses);

    }

    @PostMapping("user")
    public UsersResponse addUserInfo(@RequestBody UserBody userBody) {
        User user = new User(userBody.getName(), userBody.getAge());
        User user_saved = userRepository.save(user);
        return new UsersResponse(user_saved.getId(), user_saved.getName());

    }


}
