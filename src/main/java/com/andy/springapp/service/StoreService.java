package com.andy.springapp.service;

import com.andy.springapp.repo.StoreRepo;
import com.andy.springapp.exception.ResourceNotFoundException;
import com.andy.springapp.model.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class StoreService {

    @Autowired
    private StoreRepo storeRepo;

    public StoreService(StoreRepo storeRepo) {
        this.storeRepo = storeRepo;
    }

    public List<Store> getStore(){
        return storeRepo.findAll();
    }

    public void addNewStore(Store store) {
        storeRepo.save(store);
    }

    public ResponseEntity<Store> getStoreById(@PathVariable int id){
        Store store= storeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Store not exist with id:" + id));
        return ResponseEntity.ok(store);
    }

    public ResponseEntity<Store> updateStore(@PathVariable int id,@RequestBody Store storeDetails){
        Store store= storeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Store not exist with id:" + id));


        store.setUsers(store.getUsers());

        return ResponseEntity.ok(store);
    }

    public  ResponseEntity<HttpStatus> removeStore(@PathVariable int id){
        Store store= storeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Store not exist with id:" + id));
        storeRepo.delete(store);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
