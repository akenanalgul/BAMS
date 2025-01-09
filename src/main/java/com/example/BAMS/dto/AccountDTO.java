package com.example.BAMS.dto;

import com.example.BAMS.model.Account;
import com.example.BAMS.model.User;

public class AccountDTO extends Account {

    private Long id;
    private Double balance;
    private User user;


    public Long getId(){
        return id;
    }
    public void setId(Long id){this.id=id;}


    public String getAccountNumber() {
        return super.getAccountNumber();
    }

    public void setAccountNumber(String accountNumber) {
        super.setAccountNumber(accountNumber);
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
