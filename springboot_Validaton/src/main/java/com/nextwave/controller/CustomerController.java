package com.nextwave.controller;


import com.nextwave.exception.RecordNotFoundException;
import com.nextwave.model.Customer;
import com.nextwave.service.ICustomerService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @PostMapping("/signup")
    public ResponseEntity<Customer> signUp(@Valid @RequestBody Customer customer) {
        log.info("############# Trying to SignUp for new customer" + customer.getCustName());
        return new ResponseEntity<>(customerService.signUp(customer), HttpStatus.CREATED);
    }

    @GetMapping("/signin")
    public ResponseEntity<Boolean> signIn(@RequestParam String custEmailId, @RequestParam String custPassword) {
        return new ResponseEntity<>(customerService.signIn(custEmailId, custPassword), HttpStatus.OK);
    }

    @PostMapping("/saveall")
    public ResponseEntity<List<Customer>> saveAll(@Valid @RequestBody List<Customer> customers) {

        return new ResponseEntity<>(customerService.saveAll(customers), HttpStatus.CREATED);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Customer>> findAll() {

        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("findbyid/{custId}")
    public ResponseEntity<Optional<Customer>> findById(@PathVariable int custId) {

        return new ResponseEntity<>(customerService.findById(custId), HttpStatus.OK);
    }

    @GetMapping("/findbyname")
    public ResponseEntity<List<Customer>> findByName(@RequestParam String custName) {

        return new ResponseEntity<>(customerService.findByName(custName), HttpStatus.OK);
    }

    @PutMapping("/update/{custId}")
    public ResponseEntity<Customer> update(@PathVariable int custId, @Valid @RequestBody Customer customer) {

        Customer customer1 = customerService.findById(custId).orElseThrow(() -> new RecordNotFoundException("Customer #Id does not exists!"));

        customer1.setCustName(customer.getCustName());
        customer1.setCustAddress(customer.getCustAddress());
        customer1.setCustAccountBalance(customer.getCustAccountBalance());
        customer1.setCustContactNumber(customer.getCustContactNumber());
        customer1.setCustDOB(customer.getCustDOB());
        customer1.setCustEmailId(customer.getCustEmailId());
        customer1.setCustPassword(customer.getCustPassword());

        return new ResponseEntity<>(customerService.update(customer1), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletebyid")
    public ResponseEntity<String> deleteById(@PathVariable int custId) {

        customerService.deleteById(custId);
        return ResponseEntity.ok("Data Deleted SuccessFully!");
    }

    @DeleteMapping("deleteall")
    public ResponseEntity<String> deleteAll() {
        customerService.deleteAll();
        return ResponseEntity.ok("All Data Deleted Successfully!");
    }


}
