package com.dpv.entregable03.TransactionMs.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "AccountMs", url = "localhost:8090/api/accounts")
public interface AccountClient {

    @GetMapping("/id/{id}")
    public Account getAccountById(@PathVariable Long id);

    @PutMapping("/{id}/deposit")
    public Account depositBalance(@PathVariable Long id, @RequestBody Double amount);

    @PutMapping("/{id}/remove")
    public Account removeBalance(@PathVariable Long id, @RequestBody Double amount);
}
