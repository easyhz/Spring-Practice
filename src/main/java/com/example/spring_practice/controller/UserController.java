package com.example.spring_practice.controller;

import com.example.spring_practice.entity.Users;
import com.example.spring_practice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    // RequestParam -> params .. GET
    @GetMapping(value = "/users")
    public List<Users> getUsers(@RequestParam(required = false, defaultValue = "") String name) {
        log.info("[ USER CONTROLLEr              ] : " + name);
        return userService.getUsersService(name);
    }

    @PostMapping(value = "/user")
    public String createUser(@RequestBody Users user) {
        return userService.createUserService(user);
    }

}
