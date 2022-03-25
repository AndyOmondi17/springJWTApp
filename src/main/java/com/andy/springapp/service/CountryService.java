package com.andy.springapp.service;;


import com.andy.springapp.repo.CountryRepo;
import com.andy.springapp.exception.ResourceNotFoundException;
import com.andy.springapp.model.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepo countryRepo;


    public CountryService(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    public List<Country> getCountry(){
        return countryRepo.findAll();
    }

    public void addNewCountry(Country country) {
        countryRepo.save(country);
    }

    public ResponseEntity<Country> getCountryById(@PathVariable int id){
        Country country=countryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Country not exist with id:" + id));
        return ResponseEntity.ok(country);
    }

    public Page<Country> getCountries(Pageable pageable) {
        return countryRepo.findAll(pageable);
    }

    public ResponseEntity<Country> updateCountry(@PathVariable int id,@RequestBody Country countryDetails){
        Country country=countryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Country not exist with id:" + id));

        countryDetails.setCountry(country.getCountry());

        countryRepo.save(countryDetails);
        return ResponseEntity.ok(country);
    }

    public  ResponseEntity<HttpStatus> removeCountry(@PathVariable int id){
        Country country=countryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Country not exist with id:" + id));
        countryRepo.delete(country);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
