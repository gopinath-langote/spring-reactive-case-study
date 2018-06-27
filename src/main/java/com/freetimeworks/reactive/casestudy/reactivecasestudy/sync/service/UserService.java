package com.freetimeworks.reactive.casestudy.reactivecasestudy.sync.service;

import com.freetimeworks.reactive.casestudy.reactivecasestudy.User;
import com.freetimeworks.reactive.casestudy.reactivecasestudy.sync.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile(value = {"sync"})
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getByRegion(String region) {
        return userRepository.getByRegion(region);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
