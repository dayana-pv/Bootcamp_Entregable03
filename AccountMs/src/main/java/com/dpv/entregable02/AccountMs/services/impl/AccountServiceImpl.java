package com.dpv.entregable02.AccountMs.services.impl;

import com.dpv.entregable02.AccountMs.domain.Account;
import com.dpv.entregable02.AccountMs.domain.AccountType;
import com.dpv.entregable02.AccountMs.dto.AccountRequest;
import com.dpv.entregable02.AccountMs.dto.BalanceRequest;
import com.dpv.entregable02.AccountMs.repositories.AccountRepository;
import com.dpv.entregable02.AccountMs.services.AccountService;
import com.dpv.entregable02.AccountMs.utils.AccountNumberGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountNumberGenerator accountNumberGenerator;

    @Override
    public Account saveAccount(AccountRequest accountRequest) {
        Account account = Account.builder()
                .accountNumber(accountNumberGenerator.accountNumberGenerator())
                .balance(0.0)
                .accountType(accountRequest.getAccountType())
                .customerId(accountRequest.getCustomerId())
                .build();

        accountRepository.save(account);

        return account;
    }

    @Override
    public List<Account> listAccounts() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("La cuenta no existe"));
    }

    @Override
    public List<Account> getAccountsByCustomerId(Long customerId) {
        return accountRepository
                .findByCustomerId(customerId);
    }

    @Override
    public Account depositBalance(Long id, Double amount) {
        Optional<Account> account = accountRepository.findById(id);

        if(account.isEmpty()) {
            throw new RuntimeException("La cuenta no existe");
        }

        Double newBalance = account.get().getBalance() + amount;
        account.get().setBalance(newBalance);

        accountRepository.save(account.get());

        return account.get();
    }

    @Override
    public Account depositBalanceAccount(String accountNumber, Double amount) {
        Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);

        if(account.isEmpty()) {
            throw new RuntimeException("La cuenta no existe");
        }

        Double newBalance = account.get().getBalance() + amount;
        account.get().setBalance(newBalance);

        accountRepository.save(account.get());

        return account.get();
    }

    @Override
    public Account removeBalance(Long id, Double amount) {
        Optional<Account> account = accountRepository.findById(id);

        if(account.isEmpty()) {
            throw new RuntimeException("La cuenta no existe");
        }

        Double newBalance = account.get().getBalance() - amount;

        if (newBalance < 0) {
            throw new RuntimeException("No tiene suficiente saldo para realizar el retiro.");
        }

        // Si pasa las verificaciones, actualizar el saldo
        account.get().setBalance(newBalance);

        accountRepository.save(account.get());

        return account.get();
    }

    @Override
    public Account removeBalanceAccount(String accountNumber, Double amount) {
        Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);

        if(account.isEmpty()) {
            throw new RuntimeException("La cuenta no existe");
        }

        Double newBalance = account.get().getBalance() - amount;

        if (newBalance < 0) {
            throw new RuntimeException("No tiene suficiente saldo para realizar el retiro.");
        }

        // Si pasa las verificaciones, actualizar el saldo
        account.get().setBalance(newBalance);

        accountRepository.save(account.get());

        return account.get();
    }

    @Override
    public boolean deleteAccount(Long id) {
        accountRepository.deleteById(id);
        return true;
    }
}
