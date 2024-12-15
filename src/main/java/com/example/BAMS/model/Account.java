package com.example.BAMS.model;

import jakarta.persistence.*;


@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @ManyToMany
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public Double getBalance(){
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}