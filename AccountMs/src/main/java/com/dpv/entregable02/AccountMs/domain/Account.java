package com.dpv.entregable02.AccountMs.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank_accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;

    private Double balance;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name = "id_customer")
    private Long customerId;
}
