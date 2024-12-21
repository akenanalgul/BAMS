package com.example.BAMS.controller;

import com.example.BAMS.model.Account;
import com.example.BAMS.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts") // It manages request to accounts endpoint
public class AccountController {

    @Autowired
    private AccountService accountService; // Uses AccountService

// The endpoint that lists all accounts
    @GetMapping
    public List<Account> getAllAccounts(){
        return accountService.getAllAccount();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

}
