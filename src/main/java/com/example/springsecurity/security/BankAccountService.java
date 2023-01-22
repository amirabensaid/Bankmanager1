package com.example.springsecurity.security;


import com.example.springsecurity.domain.BankAccount;
import com.example.springsecurity.exception.BankAccountNotFoundException;
import com.example.springsecurity.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public List<BankAccount> loadBankAccounts(){
        return bankAccountRepository.findAll();
    }

    public BankAccount loadBankAccount(Long id){
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new BankAccountNotFoundException("Account ID not available !!"));
    }

    public BankAccount deposit(Long id, double amount){
        BankAccount bankAccount = loadBankAccount(id);
        bankAccount.deposit(amount);
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount withdraw(Long id, double amount){
        BankAccount bankAccount = loadBankAccount(id);
        bankAccount.withdraw(amount);
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount createBankAccount(double amount){
        return bankAccountRepository.save(new BankAccount(amount));
    }

    public void deleteBankAccount(Long id) {
        bankAccountRepository.delete(loadBankAccount(id));
    }
}
