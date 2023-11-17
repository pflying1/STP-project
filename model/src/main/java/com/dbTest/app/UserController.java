package com.dbTest.app;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/users")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}
