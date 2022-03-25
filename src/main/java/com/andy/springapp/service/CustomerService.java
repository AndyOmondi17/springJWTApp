package com.andy.springapp.service;;
import com.andy.springapp.model.Customer;
import com.andy.springapp.repo.CustomerRepo;
import com.andy.springapp.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;


    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getCustomer(){
        return customerRepo.findAll();
    }

    public void addNewCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    public ResponseEntity<Customer> getCustomerById(@PathVariable int id){
        Customer customer=customerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer not exist with id:" + id));
        return ResponseEntity.ok(customer);
    }

    public ResponseEntity<Customer> updateCustomer(@PathVariable int id,@RequestBody Customer customerDetails){
        Customer customer=customerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer not exist with id:" + id));

        customer.setActive(customer.isActive());
        customer.setEmail(customer.getEmail());

        return ResponseEntity.ok(customer);
    }

    public  ResponseEntity<HttpStatus> removeCustomer(@PathVariable int id){
        Customer customer=customerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer not exist with id:" + id));
        customerRepo.delete(customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
