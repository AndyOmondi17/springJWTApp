package com.andy.springapp.ApiControllers;;


import com.andy.springapp.model.Country;
import com.andy.springapp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CountryControllers {

    @Autowired
    private CountryService countryService;

    public CountryControllers(CountryService countryService) {
        this.countryService = countryService;
    }


    // get all actors
    @GetMapping(value = "/country")
    public List<Country> getAllCountry(){
        return countryService.getCountry();
    }

    @GetMapping(value = "/country/pages")
    public Page<Country> getAllCountries(@RequestParam(defaultValue = "0") Integer pageNo,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                         @RequestParam(defaultValue = "countryID") String sortBy){
//        @RequestParam(defaultValue = "id") String sortBy
//        ,Sort.by(sortBy)


        Pageable pageable = PageRequest.of(pageNo, pageSize,Sort.by(sortBy));
        return countryService.getCountries(pageable);
    }


    //create actor for api
    @PostMapping("/country")
    public void createCountry(@RequestBody Country country){
        countryService.addNewCountry(country);
    }

    //    get actor by id
    @GetMapping(value = "/country/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable("id")Integer id){
        return countryService.getCountryById(id);
    }

    // update actor Rest API
    @PutMapping(value = "/country/{id}")
    public ResponseEntity<Country> editCountry(@PathVariable("id") int id,@RequestBody() Country country){
        return countryService.updateCountry(id,country);
    }

    // delete actor from rest API
    @DeleteMapping(value = "/country/{id}")
    public ResponseEntity<HttpStatus> deleteCountry(@PathVariable("id")int id){
        return countryService.removeCountry(id);
    }
}
