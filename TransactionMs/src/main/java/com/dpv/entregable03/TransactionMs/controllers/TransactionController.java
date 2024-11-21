package com.dpv.entregable03.TransactionMs.controllers;

import com.dpv.entregable03.TransactionMs.domain.Transaction;
import com.dpv.entregable03.TransactionMs.dto.TransactionRequest;
import com.dpv.entregable03.TransactionMs.dto.TransferRequest;
import com.dpv.entregable03.TransactionMs.services.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/deposit")
    public Mono<Transaction> registerDeposit(@RequestBody @Valid TransactionRequest transactionRequest){
        return transactionService.registerDeposit(transactionRequest);
    }

    @PostMapping("/withdrawal")
    public Mono<Transaction> registerWithdrawal(@RequestBody @Valid TransactionRequest transactionRequest){
        return transactionService.registerWithdrawal(transactionRequest);
    }

    @PostMapping("/transfer")
    public Mono<Transaction> registerTransfer(@RequestBody @Valid TransferRequest transferRequest){
        return transactionService.registerTransfer(transferRequest);
    }

    @GetMapping("/history")
    public Flux<Transaction> listTransactions(){
        return transactionService.listTransactions();
    }
}
