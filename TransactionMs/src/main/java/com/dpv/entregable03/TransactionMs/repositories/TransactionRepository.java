package com.dpv.entregable03.TransactionMs.repositories;

import com.dpv.entregable03.TransactionMs.domain.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {
}
