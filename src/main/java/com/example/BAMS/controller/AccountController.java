package com.example.BAMS.controller;

import com.example.BAMS.model.Account;
import com.example.BAMS.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @GetMapping
    public List<Account> getAllAccounts(){
        return accountService.getAllAccount();
    }

}
