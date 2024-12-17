package com.example.BAMS.service;

import com.example.BAMS.model.Transactions;
import com.example.BAMS.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TransactionsService {
        public final TransactionsRepository transactionsRepository;

@Autowired
        public TransactionsService(TransactionsRepository transactionsRepository){
            this.transactionsRepository = transactionsRepository;
}
        public Transactions createTransactions(Transactions transactions){
            return transactionsRepository.save(transactions);
        }
        public List<Transactions> getAllTransactions(){
            return transactionsRepository.findAll();
        }
        public Transactions getTransactionById(Long id){
            return transactionsRepository.findById(id).orElseThrow(()->new RuntimeException("Transaction not found!"));
        }
        public void deleteTransaction(Long id){
            transactionsRepository.deleteById(id);
        }




}
