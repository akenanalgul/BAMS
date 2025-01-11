package com.example.BAMS.dto;

import com.example.BAMS.model.Account;
import com.example.BAMS.model.Transactions;

import java.time.LocalDateTime;

public class TransactionsDTO extends Transactions {

    private Long id;
    private Account account;
    private String transactionType;

    private Double amount;

    private LocalDateTime createdAt;


    public Long getId(){ return id;}
    public void setId(Long id){this.id=id;}

    public Account getAccount(){return account;}
    public void setAccount(Account account){this.account=account;}

    public String getTransactionType(){return transactionType;}
    public void setTransactionType(String transactionType){this.transactionType=transactionType;}

    public Double getAmount(){return amount;}
    public void setAmount(Double amount){this.amount=amount;}

    public LocalDateTime getCreatedAt(){return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
}
