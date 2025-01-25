package com.example.BAMS.dto;

import com.example.BAMS.model.Account;
import com.example.BAMS.model.User;

public class AccountDTO {

    private Long id;
    private String accountNumber;
    private Double balance;
    private User user;


    public Long getId(){
        return id;
    }
    public void setId(Long id){this.id=id;}


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber=accountNumber;
    }

    public Double getBalance(){
        return balance;
    }
    public void setBalance(Double balance){this.balance=balance;}

    public User getUser(){
        return  user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
