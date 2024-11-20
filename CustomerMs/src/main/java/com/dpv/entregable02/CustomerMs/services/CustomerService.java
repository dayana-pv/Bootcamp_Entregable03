package com.dpv.entregable02.CustomerMs.services;

import com.dpv.entregable02.CustomerMs.domain.Customer;
import com.dpv.entregable02.CustomerMs.dto.CustomerRequest;

import java.util.List;

public interface CustomerService {

    public Customer registerCustomer(CustomerRequest customerRequest);
    public List<Customer> listCustomers();
    public Customer findCustomerId(Long id);
    public Customer updateCustomer(Long id, CustomerRequest customerRequest);
    public boolean deleteCustomer(Long id);



}
