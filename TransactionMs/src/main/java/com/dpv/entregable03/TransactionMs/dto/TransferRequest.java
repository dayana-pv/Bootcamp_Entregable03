package com.dpv.entregable03.TransactionMs.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TransferRequest extends TransactionRequest {

    @NotNull
    private String destinyAccount;

    public TransferRequest(Double amount, String originAccount, String destinyAccount){
        super(amount, originAccount);
        this.destinyAccount = destinyAccount;
    }

}
