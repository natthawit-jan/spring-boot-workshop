package com.natthawitjan.demo.controller;

import com.natthawitjan.demo.pojo.UserBody;
import com.natthawitjan.demo.pojo.UserResponseWithPage;
import com.natthawitjan.demo.pojo.UsersResponse;
import com.natthawitjan.demo.repository.User;
import com.natthawitjan.demo.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("user/{id}")
    public ResponseEntity<UsersResponse> getUser(@PathVariable int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return (optionalUser.isEmpty()) ?
                ResponseEntity.status(404).build() :
                ResponseEntity.ok(new UsersResponse(optionalUser.get().getId(), optionalUser.get().getName()));


    }


    @GetMapping("users")
    public UserResponseWithPage getAllUsers(
            @RequestParam(defaultValue = "1") String page,
            @RequestParam(defaultValue = "10", name = "item_per_page") String itemPerPage) {
        int numberOfItems = Integer.parseInt(itemPerPage);
        int pageNumber = Integer.parseInt(page);

        Pageable pageWithSize = PageRequest.of(pageNumber - 1, numberOfItems);
        Page<User> usersInPage = userRepository.findAll(pageWithSize);
        List<UsersResponse> users = new ArrayList<>();

        for (User user : usersInPage
        ) {
            users.add(new UsersResponse(user.getId(), user.getName()));

        }
        return new UserResponseWithPage(pageNumber, numberOfItems, users, usersInPage.getNumberOfElements());

    }

    @PostMapping("user")
    public UsersResponse addUserInfo(@RequestBody UserBody userBody) {
        User user = new User(userBody.getName(), userBody.getAge());
        User user_saved = userRepository.save(user);
        return new UsersResponse(user_saved.getId(), user_saved.getName());

    }


}
