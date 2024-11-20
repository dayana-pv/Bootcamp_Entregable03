package com.dpv.entregable03.TransactionMs.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class TransactionRequest {
    private String type;

    private Double amount;

    private String date;

    private String account;
}



