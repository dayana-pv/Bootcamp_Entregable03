package com.dpv.entregable02.AccountMs.repositories;

import com.dpv.entregable02.AccountMs.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    public List<Account> findByCustomerId(Long customerId);
    public Optional<Account> findByAccountNumber(String accountNumber);
}
