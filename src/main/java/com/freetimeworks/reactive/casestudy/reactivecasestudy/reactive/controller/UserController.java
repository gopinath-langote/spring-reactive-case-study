package com.freetimeworks.reactive.casestudy.reactivecasestudy.reactive.controller;

import com.freetimeworks.reactive.casestudy.reactivecasestudy.User;
import com.freetimeworks.reactive.casestudy.reactivecasestudy.reactive.service.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/reactive/users")
@Profile(value = {"reactive"})
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "{region}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Flux<User> get(@PathVariable("region") String region) {
        return userService.getUsers(region);
    }
}
