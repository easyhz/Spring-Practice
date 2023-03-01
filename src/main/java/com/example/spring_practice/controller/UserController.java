package com.example.spring_practice.controller;

import com.example.spring_practice.entity.Users;
import com.example.spring_practice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/users")
    public List<Users> getUsers(@RequestParam(required = false, defaultValue = "") String name) {
        return userService.getUsersService(name);
    }

    @PostMapping(value = "/user")
    public String createUser(@RequestBody Users user) {
        return userService.createUserService(user);
    }

}
