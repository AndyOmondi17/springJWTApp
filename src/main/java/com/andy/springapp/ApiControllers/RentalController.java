package com.andy.springapp.ApiControllers;


import com.andy.springapp.model.Rental;
import com.andy.springapp.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class RentalController {
    @Autowired
    private RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    // get all actors
    @GetMapping(value = "/rental")
    public List<Rental> getAllRental(){
        return rentalService.getRental();
    }

    //    I can't post an actor
    //create actor for api
    @PostMapping("/rental")
    public void createRental(@RequestBody Rental country){
        rentalService.addNewRental(country);
    }

    //    get actor by id
    @GetMapping(value = "/rental/{id}")
    public ResponseEntity<Rental> getRentalById(@PathVariable("id")Integer id){
        return rentalService.getRentalById(id);
    }

    // update actor Rest API
    @PutMapping(value = "/rental/{id}")
    public ResponseEntity<Rental> editRental(@PathVariable("id") int id,@RequestBody() Rental country){
        return rentalService.updateRental(id,country);
    }

    // delete actor from rest API
    @DeleteMapping(value = "/rental/{id}")
    public ResponseEntity<HttpStatus> deleteRental(@PathVariable("id")int id){
        return rentalService.removeRental(id);
    }
}
