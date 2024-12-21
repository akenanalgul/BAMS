package com.example.BAMS.controller;


import com.example.BAMS.model.Transactions;
import com.example.BAMS.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionsController {
    @Autowired
    private TransactionsService transactionsService;

    @GetMapping
    public List<Transactions> getAllTransactions(){
        return transactionsService.getAllTransactions();
    }
    @PostMapping
    public Transactions createTransaction(@RequestBody Transactions transactions){
        return transactionsService.createTransactions(transactions);
    }

}
