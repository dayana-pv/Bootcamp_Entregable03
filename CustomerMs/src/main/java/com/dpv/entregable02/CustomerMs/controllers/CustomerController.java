package com.dpv.entregable02.CustomerMs.controllers;

import com.dpv.entregable02.CustomerMs.domain.Customer;
import com.dpv.entregable02.CustomerMs.dto.CustomerRequest;
import com.dpv.entregable02.CustomerMs.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping()
    public Customer registerCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        return customerService.registerCustomer(customerRequest);
    }

    @GetMapping()
    public List<Customer> listCustomers() {
        return customerService.listCustomers();
    }

    @GetMapping("/{id}")
    public Customer findCustomerId(@PathVariable Long id) {
        return customerService.findCustomerId(id);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody @Valid CustomerRequest customerRequest) {
        return customerService.updateCustomer(id, customerRequest);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustomer(id);
    }
}
