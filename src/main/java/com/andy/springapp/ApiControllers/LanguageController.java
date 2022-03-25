package com.andy.springapp.ApiControllers;


import com.andy.springapp.model.Language;
import com.andy.springapp.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

//    @GetMapping("/")
//    public String index() {
//        return "Greetings from Spring Boot!";
//    }

    // get all actors
    @GetMapping(value = "/language")
    public List<Language> getAllCountry(){
        return languageService.getLanguage();
    }

    //    I can't post an actor
    //create actor for api
    @PostMapping("/language")
    public void createCountry(@RequestBody Language language){
        languageService.addNewLanguage(language);
    }

    //    get actor by id
    @GetMapping(value = "/language/{id}")
    public ResponseEntity<Language> getCountryById(@PathVariable("id")Integer id){
        return languageService.getLanguageById(id);
    }

    // update actor Rest API
    @PutMapping(value = "/language/{id}")
    public ResponseEntity<Language> editCountry(@PathVariable("id") int id,@RequestBody() Language language){
        return languageService.updateLanguage(id,language);
    }

    // delete actor from rest API
    @DeleteMapping(value = "/language/{id}")
    public ResponseEntity<HttpStatus> deleteCountry(@PathVariable("id")int id){
        return languageService.removeLanguage(id);
    }
}
