package com.example.BAMS.controller;

import com.example.BAMS.dto.AccountDTO;
import com.example.BAMS.model.Account;
import com.example.BAMS.service.AccountService;
import jakarta.validation.Valid;
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
    public ResponseEntity<AccountDTO> createAccount(@Valid @RequestBody AccountDTO accountDTO){
        Account account= accountService.createAccount(accountDTO);
        AccountDTO createdAccount = accountService.convertToDTO(account);
        return ResponseEntity.ok(createdAccount);
    }
    @PostMapping("/withdraw/{id}")
    public ResponseEntity<String> withdraw(@PathVariable Long id,@RequestBody double amount){
        accountService.withdraw(id,amount);
        return ResponseEntity.ok("withdrawal successful");
    }
    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id){
        Account account = accountService.getAccountById(id);
        AccountDTO accountDTO = accountService.convertToDTO(account);
        return ResponseEntity.ok(accountDTO);
    }
    @GetMapping // Fetch all users
    public ResponseEntity<List<Account>> getAllAccount(){
        List<Account> accounts=accountService.getAllAccount();
        return ResponseEntity.ok(accounts);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id,@RequestBody Account updatedAccount){
        Account account = accountService.updateAccount(id,updatedAccount);
        return ResponseEntity.ok(account);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

}
