package com.dpv.entregable02.CustomerMs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerRequest {
    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private String dni;

    @NotNull
    @Email
    private String email;
}
