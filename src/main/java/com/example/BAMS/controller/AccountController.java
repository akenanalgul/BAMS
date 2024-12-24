package com.example.BAMS.controller;

import com.example.BAMS.model.Account;
import com.example.BAMS.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts") // It manages request to accounts endpoint
public class AccountController {
    private final AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService){
        this.accountService=accountService;
    }


    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        Account createdAccount = accountService.createAccount(account);
        return ResponseEntity.ok(createdAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id,@RequestBody Account updatedAccount){
        Account account = accountService.updateAccount(id,updatedAccount);
        return ResponseEntity.ok(account);
    }
    @GetMapping // Fetch all users
    public ResponseEntity<List<Account>> getAllAccount(){
        List<Account> accounts=accountService.getAllAccount();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id){
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

















}
