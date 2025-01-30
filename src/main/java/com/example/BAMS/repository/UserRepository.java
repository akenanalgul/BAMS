package com.example.BAMS.repository;

import com.example.BAMS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Özel sorgular eklenebilir
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
