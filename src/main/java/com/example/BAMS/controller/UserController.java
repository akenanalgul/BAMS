package com.example.BAMS.controller;

import com.example.BAMS.model.User;
import com.example.BAMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService; // UserService'i kullanarak iş mantığına erişim sağlar

    // Tüm kullanıcıları listeleyen endpoint
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
