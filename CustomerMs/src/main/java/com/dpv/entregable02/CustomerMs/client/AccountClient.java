package com.dpv.entregable02.CustomerMs.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "AccountMs", url = "localhost:8090/api/accounts")
public interface AccountClient {
    @GetMapping("/customer/{customerId}")
    List<Account> getAccountByCustomerId(@PathVariable Long customerId);
}
