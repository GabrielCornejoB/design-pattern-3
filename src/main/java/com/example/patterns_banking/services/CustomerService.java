package com.example.patterns_banking.services;

import com.example.patterns_banking.dtos.CustomerDTO;
import com.example.patterns_banking.models.Customer;
import com.example.patterns_banking.services.proxy.ICustomerOperations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
  private final ICustomerOperations proxy;

  public Customer create(CustomerDTO customerDTO) {
    return this.proxy.create(customerDTO);
  }
}
