package com.nextwave.service;


import com.nextwave.model.Customer;
import com.nextwave.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Customer signUp(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean signIn(String custEmailId, String custPassword) {

        boolean flag = false;

        Customer customer = customerRepository.findByCustEmailIdAndCustPassword(custEmailId, custPassword);

        if (customer != null && customer.getCustEmailId().equals(custEmailId) && customer.getCustPassword().equals(custPassword)) {

            flag = true;
        }
        return flag;
    }

    @Override
    public List<Customer> saveAll(List<Customer> customers) {
        return customerRepository.saveAll(customers);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(int custId) {
        return customerRepository.findById(custId);
    }

    @Override
    public List<Customer> findByName(String custName) {
        return customerRepository.findByCustName(custName);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(int custId) {
        customerRepository.deleteById(custId);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }
}
