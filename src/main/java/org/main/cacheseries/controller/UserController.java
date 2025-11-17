package org.main.cacheseries.controller;

import org.main.cacheseries.entity.User;
import org.main.cacheseries.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/main")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getuser/{email}")
    public User getUser(@PathVariable("email") String email){
        System.out.println("Email:"+email);
        return userService.findByEmail(email);
    }
}
