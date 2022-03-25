package com.andy.springapp.ApiControllers;

import com.andy.springapp.model.Customer;
import com.andy.springapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/customer")
    public List<Customer> getAllCountry(){
        return customerService.getCustomer();
    }

    @PostMapping("/customer")
    public void createCountry(@RequestBody Customer customer){
        customerService.addNewCustomer(customer);
    }


    @GetMapping(value = "/customer/{id}")
    public ResponseEntity<Customer> getCountryById(@PathVariable("id")Integer id){
        return customerService.getCustomerById(id);
    }

    // update actor Rest API
    @PutMapping(value = "/customer/{id}")
    public ResponseEntity<Customer> editCountry(@PathVariable("id") int id,@RequestBody() Customer customer){
        return customerService.updateCustomer(id,customer);
    }

    // delete actor from rest API
    @DeleteMapping(value = "/customer/{id}")
    public ResponseEntity<HttpStatus> deleteCountry(@PathVariable("id")int id){
        return customerService.removeCustomer(id);
    }
}
