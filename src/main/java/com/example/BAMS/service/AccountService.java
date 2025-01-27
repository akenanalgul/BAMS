package com.example.BAMS.service;
import com.example.BAMS.dto.AccountDTO;
import com.example.BAMS.dto.UserDTO;
import com.example.BAMS.exception.AccountNotFoundException;
import com.example.BAMS.exception.InsufficientFundsException;
import com.example.BAMS.model.Account;
import com.example.BAMS.model.User;
import com.example.BAMS.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.InsufficientResourcesException;
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
    public AccountDTO convertToDTO(Account account) {
        return modelMapper.map(account,AccountDTO.class);
    }
    public Account convertToEntity(AccountDTO accountDTO){return modelMapper.map(accountDTO,Account.class);}

    @Transactional
    public void withdraw(Long id,double amount){
        Account account=accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException("Account with ID"+id+"not found!"));

        if (account.getBalance()<amount){
            throw new InsufficientFundsException("Insufficient balance for withdrawal");
        }
        account.setBalance(account.getBalance());
        accountRepository.save(account);
    }









    public Account getAccountById(Long id){
        return accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException("Account with ID"+ id + "not found!"));
    }

    public Account createAccount(AccountDTO accountDTO){
        Account account = convertToEntity(accountDTO);
                if(account.getBalance()<100){
                    throw new IllegalArgumentException("Minimum balance must be 100");
                    }
        return accountRepository.save(account);
    }

    public List<Account> getAllAccount(){
        return accountRepository.findAll();
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
