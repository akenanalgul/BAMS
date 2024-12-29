package com.example.BAMS.service;

import com.example.BAMS.model.Account;
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
    public Transactions updateTransaction(Long id, Transactions updatedTransactions) {
        // Mevcut işlemi kontrol et
       // Transactions existingTransactions = transactionsRepository.findById(id);
        Transactions existingTransactions = getTransactionById(id);
        // Güncellenmiş değerleri mevcut işlemle değiştir
        existingTransactions.setTransactionType(updatedTransactions.getTransactionType());
        existingTransactions.setAmount(updatedTransactions.getAmount());
        existingTransactions.setAccount(updatedTransactions.getAccount());

        // Güncellenmiş işlemi kaydet
        return transactionsRepository.save(existingTransactions);
    }
    public void deleteTransactions(Long id){
    transactionsRepository.deleteById(id);
    }




}
