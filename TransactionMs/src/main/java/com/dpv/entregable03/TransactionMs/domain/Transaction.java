package com.dpv.entregable03.TransactionMs.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private String date;

    private String account;

    @Column(name = "id_account")
    private Long accountId;
}
