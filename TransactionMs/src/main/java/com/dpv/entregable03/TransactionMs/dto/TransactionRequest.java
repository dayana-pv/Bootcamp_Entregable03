package com.dpv.entregable03.TransactionMs.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TransactionRequest {

    @NotNull
    private Double amount;

    @NotNull
    private Long originAccount;

}



