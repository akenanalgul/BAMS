package com.example.BAMS.controller;

import com.example.BAMS.dto.LoginRequestDTO;
import com.example.BAMS.dto.RegisterRequestDTO;
import com.example.BAMS.model.Role;
import com.example.BAMS.model.User;
import com.example.BAMS.repository.UserRepository;
import com.example.BAMS.security.JwtUtil;
import com.example.BAMS.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthService authService;

    public AuthController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder,AuthService authService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authService=authService;
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

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO request) {
        String token = authService.login(request);
        return ResponseEntity.ok(token);
    }
    /*
        User user = userRepository.findByEmail(request.getEmail());

        if (user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }

        String token = JwtUtil.generateToken(user.getEmail());
        return ResponseEntity.ok(token);

     */

}
