package com.andy.springapp.service;;

import com.andy.springapp.model.Address;
import com.andy.springapp.repo.AddressRepo;
import com.andy.springapp.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;


    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    public List<Address> getAddress(){
        return addressRepo.findAll();
    }

    public void addNewAddress(Address address) {
        addressRepo.save(address);
    }

    public ResponseEntity<Address> getAddressById(@PathVariable int id){
        Address address=addressRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Address not exist with id:" + id));
        return ResponseEntity.ok(address);
    }

    public ResponseEntity<Address> updateAddress(@PathVariable int id,@RequestBody Address addressDetails){
        Address address=addressRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Address not exist with id:" + id));

        addressDetails.setAddress(address.getAddress());
        address.setAddress2(address.getAddress2());

        address.setDistrict(address.getDistrict());

        addressRepo.save(addressDetails);
        return ResponseEntity.ok(address);
    }

    public  ResponseEntity<HttpStatus> removeAddres(@PathVariable int id){
        Address address=addressRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Address not exist with id:" + id));
        addressRepo.delete(address);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
