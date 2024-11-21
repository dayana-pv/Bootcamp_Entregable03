package com.dpv.entregable03.TransactionMs.services;

import com.dpv.entregable03.TransactionMs.domain.Transaction;
import com.dpv.entregable03.TransactionMs.dto.TransactionRequest;
import com.dpv.entregable03.TransactionMs.dto.TransferRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {
    public Mono<Transaction> registerDeposit(TransactionRequest transactionRequest);
    public Mono<Transaction> registerWithdrawal(TransactionRequest transactionRequest);
    public Mono<Transaction> registerTransfer(TransferRequest transferRequest);
    public Flux<Transaction> listTransactions();
}
