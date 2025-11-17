package org.main.cacheseries.service;

import org.main.cacheseries.entity.User;
import org.main.cacheseries.repo.UserRepo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Cacheable(value="usersjson", key="#email")
    public User findByEmail(String email) {
        System.out.println("*************Method Executed***************");
        return userRepo.findByEmail(email);
    }

}
