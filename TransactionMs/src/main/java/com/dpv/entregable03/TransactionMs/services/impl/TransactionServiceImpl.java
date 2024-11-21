package com.dpv.entregable03.TransactionMs.services.impl;

import com.dpv.entregable03.TransactionMs.client.AccountClient;
import com.dpv.entregable03.TransactionMs.domain.Transaction;
import com.dpv.entregable03.TransactionMs.domain.TransactionType;
import com.dpv.entregable03.TransactionMs.dto.TransactionRequest;
import com.dpv.entregable03.TransactionMs.dto.TransferRequest;
import com.dpv.entregable03.TransactionMs.repositories.TransactionRepository;
import com.dpv.entregable03.TransactionMs.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountClient accountClient;

    @Override
    public Mono<Transaction> registerDeposit(TransactionRequest transactionRequest) {

        //accountClient.depositBalance(transactionRequest.getOriginAccount(), transactionRequest.getAmount());

        Transaction transaction = Transaction.builder()
                .transactionType(TransactionType.DEPOSITO)
                .amount(transactionRequest.getAmount())
                .date(LocalDateTime.now())
                .originAccount(transactionRequest.getOriginAccount())
                .build();

        return transactionRepository.save(transaction);
    }

    @Override
    public Mono<Transaction> registerWithdrawal(TransactionRequest transactionRequest) {

        //accountClient.removeBalance(transactionRequest.getOriginAccount(), transactionRequest.getAmount());

        Transaction transaction = Transaction.builder()
                .transactionType(TransactionType.RETIRO)
                .amount(transactionRequest.getAmount())
                .date(LocalDateTime.now())
                .originAccount(transactionRequest.getOriginAccount())
                .build();

        return transactionRepository.save(transaction);
    }

    @Override
    public Mono<Transaction> registerTransfer(TransferRequest transferRequest) {

        //accountClient.removeBalance(transferRequest.getOriginAccount(), transferRequest.getAmount());
        //accountClient.depositBalance(transferRequest.getOriginAccount(), transferRequest.getAmount());

        Transaction transaction = Transaction.builder()
                .transactionType(TransactionType.TRANSFERENCIA)
                .amount(transferRequest.getAmount())
                .date(LocalDateTime.now())
                .originAccount(transferRequest.getOriginAccount())
                .destinyAccount(transferRequest.getDestinyAccount())
                .build();

        return transactionRepository.save(transaction);
    }

    @Override
    public Flux<Transaction> listTransactions(){
        return transactionRepository.findAll();
    }
}
