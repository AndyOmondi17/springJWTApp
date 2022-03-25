package com.andy.springapp.service;;

import com.andy.springapp.model.Rental;
import com.andy.springapp.exception.ResourceNotFoundException;
import com.andy.springapp.repo.RentalRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class RentalService {
    @Autowired
    private RentalRepo rentalRepo;


    public RentalService(RentalRepo rentalRepo) {
        this.rentalRepo = rentalRepo;
    }

    public List<Rental> getRental(){
        return rentalRepo.findAll();
    }

    public void addNewRental(Rental rental) {
        rentalRepo.save(rental);
    }

    public ResponseEntity<Rental> getRentalById(@PathVariable int id){
        Rental rental= rentalRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Rental not exist with id:" + id));
        return ResponseEntity.ok(rental);
    }

    public ResponseEntity<Rental> updateRental(@PathVariable int id,@RequestBody Rental rentalDetails){
        Rental rental= rentalRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Rental not exist with id:" + id));

        rentalDetails.setRentalDate(rental.getRentalDate());
        rental.setRentalDate(rental.getRentalDate());
        rental.setReturnDate(rental.getReturnDate());
        return ResponseEntity.ok(rental);
    }

    public  ResponseEntity<HttpStatus> removeRental(@PathVariable int id){
        Rental rental= rentalRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Rental not exist with id:" + id));
        rentalRepo.delete(rental);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
