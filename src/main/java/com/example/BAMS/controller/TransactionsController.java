package com.example.BAMS.controller;


import com.example.BAMS.dto.TransactionsDTO;
import com.example.BAMS.model.Transactions;
import com.example.BAMS.service.TransactionsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionsController {

    private final  TransactionsService transactionsService;
    @Autowired
    public TransactionsController(TransactionsService transactionsService){this.transactionsService=transactionsService;}


    @PostMapping
    public ResponseEntity<Transactions> createTransactions(@Valid @RequestBody TransactionsDTO transactionsDTO){
        Transactions transactions = transactionsService.createTransactions(transactionsDTO);
        TransactionsDTO createdTransactions=transactionsService.convertToDTO(transactions);
        return ResponseEntity.ok(transactionsDTO);
    }
    @GetMapping
    public ResponseEntity<List<Transactions>> getAllTransactions(){
        List<Transactions> transactions=transactionsService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TransactionsDTO> getTransactionById(@PathVariable Long id) {
        Transactions transactions= transactionsService.getTransactionById(id);
        TransactionsDTO transactionDTO = transactionsService.convertToDTO(transactions);
        return ResponseEntity.ok(transactionDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transactions> updateTransaction(
            @PathVariable Long id,
            @RequestBody Transactions transaction
    ) {
        Transactions updatedTransaction = transactionsService.updateTransaction(id, transaction);
        return ResponseEntity.ok(updatedTransaction); // 200 OK
    }



}
