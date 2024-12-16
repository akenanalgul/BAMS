package com.example.BAMS.repository;

import com.example.BAMS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Özel sorgular eklenebilir
}
