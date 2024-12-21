package com.example.BAMS.controller;

import com.example.BAMS.model.User;
import com.example.BAMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController // The class that manages REST API operations
@RequestMapping("/users") // It manages requests to users endpoint
public class UserController {
    @Autowired
    private UserService userService; // Provides access to business logic using UserService



    // The endpoint lists all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }



    // The endpoint that fetches a spesific user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }


    // The endpoint that adds a new user
    @PostMapping

    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }


}
