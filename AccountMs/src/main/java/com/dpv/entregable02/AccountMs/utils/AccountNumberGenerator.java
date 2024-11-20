package com.dpv.entregable02.AccountMs.utils;

import org.springframework.stereotype.Component;

@Component
public class AccountNumberGenerator {
    public String accountNumberGenerator() {
        return String.format("%08d", (int)(Math.random() * 100000000));
    }
}
