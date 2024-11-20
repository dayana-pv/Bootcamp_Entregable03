package com.dpv.entregable02.AccountMs.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BalanceRequest {
    @NotNull
    private Double balance;
}
