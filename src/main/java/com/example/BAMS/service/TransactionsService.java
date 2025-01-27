package com.example.BAMS.service;

import com.example.BAMS.dto.AccountDTO;
import com.example.BAMS.dto.TransactionsDTO;
import com.example.BAMS.exception.TransactionNotFoundException;
import com.example.BAMS.model.Account;
import com.example.BAMS.model.Transactions;
import com.example.BAMS.repository.TransactionsRepository;
import jakarta.transaction.TransactionalException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionsService {
        private final TransactionsRepository transactionsRepository;
        private final ModelMapper modelMapper;



@Autowired
        public TransactionsService(TransactionsRepository transactionsRepository,ModelMapper modelMapper){
            this.transactionsRepository = transactionsRepository;
            this.modelMapper=modelMapper;
}
        public TransactionsDTO convertToDTO(Transactions transactions) {return modelMapper.map(transactions,TransactionsDTO.class);}
        public Transactions convertToEntity(TransactionsDTO transactionsDTO){return modelMapper.map(transactionsDTO,Transactions.class);}

        public Transactions createTransactions(TransactionsDTO transactionsDTO){
            Transactions transactions=convertToEntity(transactionsDTO);
            if(transactions.getCreatedAt()==null){
                transactions.setCreatedAt(LocalDateTime.now());
            }
            return transactionsRepository.save(transactions);
        }
        public List<Transactions> getAllTransactions(){
            return transactionsRepository.findAll();
        }

        public Transactions getTransactionById(Long id){
            return transactionsRepository.findById(id)
                    .orElseThrow(()->new TransactionNotFoundException("Transaction with ID"+ id +"not found!"));
        }
    public Transactions updateTransaction(Long id, Transactions updatedTransactions) {
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
