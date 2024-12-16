package com.example.BAMS.repository;

import com.example.BAMS.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
    // Özel sorgular gerekirse burada tanımlayabilirsiniz.
}
