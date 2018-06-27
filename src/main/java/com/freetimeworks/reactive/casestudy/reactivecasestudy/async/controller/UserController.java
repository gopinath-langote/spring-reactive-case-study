package com.freetimeworks.reactive.casestudy.reactivecasestudy.async.controller;

import com.freetimeworks.reactive.casestudy.reactivecasestudy.User;
import com.freetimeworks.reactive.casestudy.reactivecasestudy.async.service.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/async/users")
@Profile(value = {"async"})
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "{region}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CompletableFuture<List<User>> get(@PathVariable("region") String region) {
        return userService.getUsers(region);
    }

}
