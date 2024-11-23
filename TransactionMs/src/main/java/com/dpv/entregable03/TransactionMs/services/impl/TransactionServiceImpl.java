package com.dpv.entregable03.TransactionMs.services.impl;

import com.dpv.entregable03.TransactionMs.domain.Transaction;
import com.dpv.entregable03.TransactionMs.domain.TransactionType;
import com.dpv.entregable03.TransactionMs.dto.TransactionRequest;
import com.dpv.entregable03.TransactionMs.dto.TransferRequest;
import com.dpv.entregable03.TransactionMs.repositories.TransactionRepository;
import com.dpv.entregable03.TransactionMs.services.TransactionService;
import com.dpv.entregable03.TransactionMs.webclient.Account;
import com.dpv.entregable03.TransactionMs.webclient.AccountWebClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;


@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountWebClient accountWebClient;

    @Override
    public Mono<Transaction> registerDeposit(TransactionRequest transactionRequest) {

        Mono<Account> accountUpdate = accountWebClient.depositBalanceAccount(transactionRequest.getOriginAccount(), transactionRequest.getAmount());

        Transaction transaction = Transaction.builder()
                .transactionType(TransactionType.DEPOSITO)
                .amount(transactionRequest.getAmount())
                .date(LocalDateTime.now())
                .originAccount(transactionRequest.getOriginAccount())
                .build();

        //return transactionRepository.save(transaction);
        return accountUpdate.flatMap(account -> transactionRepository.save(transaction));
    }

    @Override
    public Mono<Transaction> registerWithdrawal(TransactionRequest transactionRequest) {

        Mono<Account> accountUpdate = accountWebClient.removeBalanceAccount(transactionRequest.getOriginAccount(), transactionRequest.getAmount());

        Transaction transaction = Transaction.builder()
                .transactionType(TransactionType.RETIRO)
                .amount(transactionRequest.getAmount())
                .date(LocalDateTime.now())
                .originAccount(transactionRequest.getOriginAccount())
                .build();

        //return transactionRepository.save(transaction);
        return accountUpdate.flatMap(account -> transactionRepository.save(transaction));
    }

    @Override
    public Mono<Transaction> registerTransfer(TransferRequest transferRequest) {

        Mono<Account> removeBalance = accountWebClient.removeBalanceAccount(transferRequest.getOriginAccount(), transferRequest.getAmount());
        Mono<Account> depositBalance = removeBalance.flatMap(account -> accountWebClient.depositBalanceAccount(transferRequest.getDestinyAccount(), transferRequest.getAmount()));

        Transaction transaction = Transaction.builder()
                .transactionType(TransactionType.TRANSFERENCIA)
                .amount(transferRequest.getAmount())
                .date(LocalDateTime.now())
                .originAccount(transferRequest.getOriginAccount())
                .destinyAccount(transferRequest.getDestinyAccount())
                .build();

        //return transactionRepository.save(transaction);
        return depositBalance.flatMap(account -> transactionRepository.save(transaction));
    }

    @Override
    public Flux<Transaction> listTransactions(){
        return transactionRepository.findAll();
    }
}
