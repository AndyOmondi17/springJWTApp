package com.andy.springapp.service;;

import com.andy.springapp.model.Language;
import com.andy.springapp.repo.LanguageRepo;
import com.andy.springapp.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class LanguageService {

    @Autowired
    private LanguageRepo languageRepo;


    public LanguageService(LanguageRepo languageRepo) {
        this.languageRepo = languageRepo;
    }

    public List<Language> getLanguage(){
        return languageRepo.findAll();
    }

    public void addNewLanguage(Language language) {
        languageRepo.save(language);
    }

    public ResponseEntity<Language> getLanguageById(@PathVariable int id){
        Language language= languageRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Language not exist with id:" + id));
        return ResponseEntity.ok(language);
    }

    public ResponseEntity<Language> updateLanguage(@PathVariable int id,@RequestBody Language languageDetails){
        Language language= languageRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Language not exist with id:" + id));

        languageDetails.setName(language.getName());




        return ResponseEntity.ok(language);
    }

    public  ResponseEntity<HttpStatus> removeLanguage(@PathVariable int id){
        Language language= languageRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Language not exist with id:" + id));
        languageRepo.delete(language);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
