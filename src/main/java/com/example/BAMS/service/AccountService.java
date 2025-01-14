package com.example.BAMS.service;
import com.example.BAMS.dto.AccountDTO;
import com.example.BAMS.dto.UserDTO;
import com.example.BAMS.model.Account;
import com.example.BAMS.model.User;
import com.example.BAMS.repository.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository; // Injecting the repository layer to access the database for Account operations.
    private final ModelMapper modelMapper;
    @Autowired // Dependency Injection, AccountService class depends on AccountRepository
    public AccountService(AccountRepository accountRepository,ModelMapper modelMapper){
        this.accountRepository=accountRepository;
        this.modelMapper=modelMapper;
    }
    public Account createAccount(AccountDTO accountDTO){
        Account account = modelMapper.map(accountDTO,Account.class);
        return accountRepository.save(account);
    }
    public List<Account> getAllAccount(){
        return accountRepository.findAll();
    }
    public Account getAccountById(Long id){
          return accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found!"));

    }
    public AccountDTO convertToDTO(Account account) {
        return modelMapper.map(account,AccountDTO.class);
    }
    public Account updateAccount(Long id,Account updatedAccount){
        Account existingAccount = getAccountById(id);
        existingAccount.setBalance(updatedAccount.getBalance());
        existingAccount.setUser(updatedAccount.getUser());
        return accountRepository.save(existingAccount);
    }

    public void deleteAccount(Long id){
        accountRepository.deleteById(id);
    }









}
