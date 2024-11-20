package com.dpv.entregable03.TransactionMs.services;

import com.dpv.entregable03.TransactionMs.domain.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {
    public Mono<Transaction> registerDeposit(String id);
    public Mono<Transaction> registerWithdrawal(String id);
    public Mono<Transaction> registerTransfer(String id);
    public Flux<Transaction> listTransactions();
}
