package com.andy.springapp.service;;


import com.andy.springapp.model.Inventory;
import com.andy.springapp.repo.InventoryRepo;
import com.andy.springapp.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;


@Service
public class InventoryService {


    @Autowired
    private InventoryRepo inventoryRepo;


    public InventoryService(InventoryRepo inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    public List<Inventory> getInventory(){
        return inventoryRepo.findAll();
    }

    public void addNewInventory(Inventory inventory) {
        inventoryRepo.save(inventory);
    }

    public ResponseEntity<Inventory> getInventoryById(@PathVariable int id){
        Inventory inventory= inventoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Inventory not exist with id:" + id));
        return ResponseEntity.ok(inventory);
    }

    public ResponseEntity<Inventory> updateInventory(@PathVariable int id,@RequestBody Inventory inventoryDetails){
        Inventory inventory= inventoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Inventory not exist with id:" + id));
        return ResponseEntity.ok(inventory);
    }

    public  ResponseEntity<HttpStatus> removeInventory(@PathVariable int id){
        Inventory inventory= inventoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Inventory not exist with id:" + id));
        inventoryRepo.delete(inventory);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
