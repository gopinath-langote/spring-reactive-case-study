package com.freetimeworks.reactive.casestudy.reactivecasestudy.reactive.service;

import com.freetimeworks.reactive.casestudy.reactivecasestudy.User;
import com.freetimeworks.reactive.casestudy.reactivecasestudy.reactive.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@Profile(value = {"reactive"})
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<User> getUsers(String region) {
        return userRepository.getByRegion(region);
    }
}
