package com.dpv.entregable03.TransactionMs.services.impl;

import com.dpv.entregable03.TransactionMs.domain.Transaction;
import com.dpv.entregable03.TransactionMs.repositories.TransactionRepository;
import com.dpv.entregable03.TransactionMs.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public Mono<Transaction> registerDeposit(String id){
        return transactionRepository.findById(id);
    }
    @Override
    public Mono<Transaction> registerWithdrawal(String id){
        return transactionRepository.findById(id);
    }
    @Override
    public Mono<Transaction> registerTransfer(String id){
        return transactionRepository.findById(id);
    }
    @Override
    public Flux<Transaction> listTransactions(){
        return transactionRepository.findAll();
    }
}
