package com.example.BAMS.model;

import jakarta.persistence.*;

import java.nio.DoubleBuffer;
import java.time.LocalDateTime;


@Entity
@Table(name = "transactions")

public class Transactions {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id",nullable = false)
    private Account account;

    @Column(name = "transaction_type",nullable = false)
    private String transactionType;

    @Column(name = "amount",nullable = false)
    private Double amount;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();


    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public Account getAccount(){
        return account;
    }
    public void setAccount(Account account){
        this.account= account;
    }


    public String getTransactionType(){
        return transactionType;
    }
    public void setTransactionType(String transactionType){
        this.transactionType=transactionType;
    }

    public Double getAmount(){
        return amount;
    }
    public void setAmount(Double amount){
        this.amount=amount;
    }


    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }
}