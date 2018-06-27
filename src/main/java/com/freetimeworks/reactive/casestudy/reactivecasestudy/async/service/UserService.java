package com.freetimeworks.reactive.casestudy.reactivecasestudy.async.service;

import com.freetimeworks.reactive.casestudy.reactivecasestudy.User;
import com.freetimeworks.reactive.casestudy.reactivecasestudy.async.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Profile(value = {"async"})
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CompletableFuture<List<User>> getUsers(String region) {
        return userRepository.getByRegion(region);
    }
}
