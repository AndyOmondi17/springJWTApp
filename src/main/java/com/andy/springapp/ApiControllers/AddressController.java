package com.andy.springapp.ApiControllers;


import com.andy.springapp.model.Address;
import com.andy.springapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    // get all actors
    @GetMapping(value = "/address")
    public List<Address> getAllAddress(){
        return addressService.getAddress();
    }

    //    I can't post an actor
    //create actor for api
    @PostMapping("/address")
    public void createAddress(@RequestBody Address address){
        addressService.addNewAddress(address);
    }

    //    get actor by id
    @GetMapping(value = "/address/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id")Integer id){
        return addressService.getAddressById(id);
    }

    // update actor Rest API
    @PutMapping(value = "/address/{id}")
    public ResponseEntity<Address> editAddress(@PathVariable("id") int id,@RequestBody() Address address){
        return addressService.updateAddress(id,address);
    }

    // delete actor from rest API
    @DeleteMapping(value = "/address/{id}")
    public ResponseEntity<HttpStatus> deleteAddress(@PathVariable("id")int id){
        return addressService.removeAddres(id);
    }
}
