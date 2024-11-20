package com.dpv.entregable02.CustomerMs.services.impl;

import com.dpv.entregable02.CustomerMs.client.Account;
import com.dpv.entregable02.CustomerMs.client.AccountClient;
import com.dpv.entregable02.CustomerMs.domain.Customer;
import com.dpv.entregable02.CustomerMs.dto.CustomerRequest;
import com.dpv.entregable02.CustomerMs.repositories.CustomerRepository;
import com.dpv.entregable02.CustomerMs.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final AccountClient accountClient;

    @Override
    public Customer registerCustomer(CustomerRequest customerRequest) {
        Optional<Customer> dni = customerRepository.findByDni(customerRequest.getDni());

        if(dni.isPresent()){
            throw new RuntimeException("El Dni ya esta registrado");
        }

        Customer customer = Customer.builder()
                .name(customerRequest.getName())
                .lastName(customerRequest.getLastName())
                .dni(customerRequest.getDni())
                .email(customerRequest.getEmail())
                .build();

        customerRepository.save(customer);

        return customer;
    }

    @Override
    public List<Customer> listCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer findCustomerId(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No existe"));
    }

    @Override
    public Customer updateCustomer(Long id, CustomerRequest customerRequest) {
        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isEmpty()){
            throw new RuntimeException("El cliente no se encuentra registrado");
        }

        customer.get().setName(customerRequest.getName());
        customer.get().setLastName(customerRequest.getLastName());
        customer.get().setDni(customerRequest.getDni());
        customer.get().setEmail(customerRequest.getEmail());

        customerRepository.save(customer.get());

        return customer.get();
    }

    @Override
    public boolean deleteCustomer(Long id) {
        List<Account> accountList = accountClient.getAccountByCustomerId(id);

        if(accountList.size() > 0) {
            throw new RuntimeException("No se puede eliminar, el cliente tiene cuentas asociadas");
        }

        customerRepository.deleteById(id);
        return true;
    }
}
