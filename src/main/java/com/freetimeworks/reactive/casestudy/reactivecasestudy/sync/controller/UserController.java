package com.freetimeworks.reactive.casestudy.reactivecasestudy.sync.controller;

import com.freetimeworks.reactive.casestudy.reactivecasestudy.User;
import com.freetimeworks.reactive.casestudy.reactivecasestudy.sync.service.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sync/users")
@Profile(value = {"sync"})
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "{region}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> get(@PathVariable("region") String region) {
        return userService.getByRegion(region);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void save(@RequestBody User user) {
        userService.save(user);
    }
}
