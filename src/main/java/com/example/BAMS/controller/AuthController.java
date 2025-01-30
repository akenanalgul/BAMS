package com.example.BAMS.controller;

import com.example.BAMS.dto.RegisterRequestDTO;
import com.example.BAMS.model.Role;
import com.example.BAMS.model.User;
import com.example.BAMS.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequestDTO request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body("Email already in use");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // Şifreyi hashle
        user.setName(request.getName());
        user.setRole(Role.USER); // Varsayılan olarak USER rolü veriyoruz

        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }
}
