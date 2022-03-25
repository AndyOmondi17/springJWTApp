package com.andy.springapp.ApiControllers;


import com.andy.springapp.model.Inventory;
import com.andy.springapp.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

//    @GetMapping("/")
//    public String index() {
//        return "Greetings from Spring Boot!";
//    }

    // get all actors
    @GetMapping(value = "/inventory")
    public List<Inventory> getAllCountry(){
        return inventoryService.getInventory();
    }

    //    I can't post an actor
    //create actor for api
    @PostMapping("/inventory")
    public void createCountry(@RequestBody Inventory inventory){
        inventoryService.addNewInventory(inventory);
    }

    //    get actor by id
    @GetMapping(value = "/inventory/{id}")
    public ResponseEntity<Inventory> getCountryById(@PathVariable("id")Integer id){
        return inventoryService.getInventoryById(id);
    }

    // update actor Rest API
    @PutMapping(value = "/inventory/{id}")
    public ResponseEntity<Inventory> editCountry(@PathVariable("id") int id,@RequestBody() Inventory inventory){
        return inventoryService.updateInventory(id,inventory);
    }

    // delete actor from rest API
    @DeleteMapping(value = "/inventory/{id}")
    public ResponseEntity<HttpStatus> deleteCountry(@PathVariable("id")int id){
        return inventoryService.removeInventory(id);
    }
}

