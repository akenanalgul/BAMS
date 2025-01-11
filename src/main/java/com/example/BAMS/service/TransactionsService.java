package com.example.BAMS.service;

import com.example.BAMS.dto.TransactionsDTO;
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
        public TransactionsDTO getTransactionById(Long id){
            Transactions transactions= transactionsRepository.findById(id).orElseThrow(()->new RuntimeException("Transaction not found!"));

            TransactionsDTO transactionsDTO = new TransactionsDTO();
            transactionsDTO.setId(transactions.getId());
            transactionsDTO.setAccount(transactions.getAccount());
            transactionsDTO.setTransactionType(transactions.getTransactionType());
            transactionsDTO.setAmount(transactions.getAmount());
            transactionsDTO.setCreatedAt(transactions.getCreatedAt());

            return transactionsDTO;
        }
    public Transactions updateTransaction(Long id, Transactions updatedTransactions) {
        Transactions existingTransactions = getTransactionById(id);
        // Güncellenmiş değerleri mevcut işlemle değiştir
        existingTransactions.setTransactionType(updatedTransactions.getTransactionType());
        existingTransactions.setAmount(updatedTransactions.getAmount());
        existingTransactions.setAccount(updatedTransactions.getAccount());
        existingTransactions.setCreatedAt(updatedTransactions.getCreatedAt());

        // Güncellenmiş işlemi kaydet
        return transactionsRepository.save(existingTransactions);
    }
    public void deleteTransactions(Long id){
    transactionsRepository.deleteById(id);
    }




}
