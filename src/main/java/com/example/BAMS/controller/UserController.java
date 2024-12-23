package com.example.BAMS.controller;

import com.example.BAMS.model.User;
import com.example.BAMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController // The class that manages REST API operations
@RequestMapping("/api/users") // It manages requests to users endpoint
public class UserController {

    private final UserService userService;




    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping // Create new user
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping // Fetch all users
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}") // Fetch user by ID
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    @PutMapping("/{id}") // Update user
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User updatedUser){
        User user =userService.updateUser(id,updatedUser);
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/{id}") // Delete user
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }




}
