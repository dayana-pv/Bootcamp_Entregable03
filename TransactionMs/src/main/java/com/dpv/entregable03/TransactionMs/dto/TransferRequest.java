package com.dpv.entregable03.TransactionMs.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TransferRequest extends TransactionRequest {

    @NotNull
    private Long destinyAccount;

    public TransferRequest(Double amount, Long originAccount, Long destinyAccount){
        super(amount, originAccount);
        this.destinyAccount = destinyAccount;
    }

}
