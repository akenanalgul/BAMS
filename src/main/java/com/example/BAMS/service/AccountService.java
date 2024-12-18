package com.example.BAMS.service;
import com.example.BAMS.model.Account;
import com.example.BAMS.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository; // Injecting the repository layer to access the database for Account operations.

    @Autowired // Dependency Injection, AccountService class depends on AccountRepository
    public AccountService(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }
    public Account createAccount(Account account){
        return accountRepository.save(account);
    }
    public List<Account> getAllAccount(){
        return accountRepository.findAll();
    }
    public Account getAccountById(Long id){
        return accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found!"));
    }
    public Account updateAccount(Long id,Account updatedAccount){
        Account existingAccount = getAccountById(id);
        existingAccount.setBalance(updatedAccount.getBalance());
        existingAccount.setUserId(updatedAccount.getUserId());
        return accountRepository.save(existingAccount);
    }

    public void deleteAccount(Long id){
        accountRepository.deleteById(id);
    }









}
