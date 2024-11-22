package com.nextwave.service;

import com.nextwave.model.Customer;
import java.util.List;
import java.util.Optional;


public interface ICustomerService {

    Customer signUp(Customer customer);

    boolean signIn(String custEmailId, String custPassword);

    List<Customer> saveAll(List<Customer> customers);

    List<Customer> findAll();

    Optional<Customer> findById(int custId);

    List<Customer> findByName(String custName);

    Customer update(Customer customer);

    void deleteById(int custId);

    void deleteAll();


}
