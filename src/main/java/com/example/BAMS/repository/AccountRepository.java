package com.example.BAMS.repository;

import com.example.BAMS.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // Özel sorgular gerekirse burada tanımlayabilirsiniz.
}
