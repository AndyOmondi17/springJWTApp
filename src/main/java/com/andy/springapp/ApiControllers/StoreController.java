package com.andy.springapp.ApiControllers;


import com.andy.springapp.service.StoreService;
import com.andy.springapp.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class StoreController {
    @Autowired
    private StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    // get all actors
    @GetMapping(value = "/store")
    public List<Store> getAllStore(){
        return storeService.getStore();
    }

    //    I can't post an actor
    //create actor for api
    @PostMapping("/store")
    public void createStore(@RequestBody Store country){
        storeService.addNewStore(country);
    }

    //    get actor by id
    @GetMapping(value = "/store/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable("id")Integer id){
        return storeService.getStoreById(id);
    }

    // update actor Rest API
    @PutMapping(value = "/store/{id}")
    public ResponseEntity<Store> editCountry(@PathVariable("id") int id,@RequestBody() Store country){
        return storeService.updateStore(id,country);
    }

    // delete actor from rest API
    @DeleteMapping(value = "/store/{id}")
    public ResponseEntity<HttpStatus> deleteCountry(@PathVariable("id")int id){
        return storeService.removeStore(id);
    }
}
