package com.dpv.entregable03.TransactionMs.controllers;

import com.dpv.entregable03.TransactionMs.domain.Transaction;
import com.dpv.entregable03.TransactionMs.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/transactions")

public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping()
    public Mono<Transaction> registerDeposit(String id){
        return transactionService.registerDeposit(id);
    }
    @PostMapping()
    public Mono<Transaction> registerWithdrawal(String id){
        return transactionService.registerWithdrawal(id);
    }
    @PostMapping()
    public Mono<Transaction> registerTransfer(String id){
        return transactionService.registerTransfer(id);
    }
    @GetMapping("/id/{id}")
    public Flux<Transaction> listTransactions(){
        return transactionService.listTransactions();
    }
}
