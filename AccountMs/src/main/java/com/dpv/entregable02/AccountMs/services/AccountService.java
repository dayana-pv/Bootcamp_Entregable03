package com.dpv.entregable02.AccountMs.services;

import com.dpv.entregable02.AccountMs.domain.Account;
import com.dpv.entregable02.AccountMs.dto.AccountRequest;
import com.dpv.entregable02.AccountMs.dto.BalanceRequest;

import java.util.List;

public interface AccountService {
    public Account saveAccount(AccountRequest accountRequest);
    public List<Account> listAccounts();
    public Account getAccountById(Long id);
    public List<Account> getAccountsByCustomerId(Long customerId);
    public Account depositBalance(Long id, BalanceRequest balanceRequest);
    public Account removeBalance(Long id, BalanceRequest balanceRequest);
    public boolean deleteAccount(Long id);
}
