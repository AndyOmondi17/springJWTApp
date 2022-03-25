package com.andy.springapp.ApiControllers;;


import com.andy.springapp.model.Film;
import com.andy.springapp.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FilmController {

    @Autowired
    private FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    //    @GetMapping("/")
//    public String index() {
//        return "Greetings from Spring Boot!";
//    }

    // get all actors
    @GetMapping(value = "/film")
    public List<Film> getAllCountry(){
        return filmService.getFilm();
    }

    //    I can't post an actor
    //create actor for api
    @PostMapping("/film")
    public void createCountry(@RequestBody Film film){
        filmService.addNewFilm(film);
    }

    //    get actor by id
    @GetMapping(value = "/film/{id}")
    public ResponseEntity<Film> getCountryById(@PathVariable("id")Integer id){
        return filmService.getFilmById(id);
    }

    @GetMapping("/film/categoryname/{name}")
    public ResponseEntity<?> findFilmByCategoryName(@PathVariable("name")String category){
        return filmService.getByCategoryName(category);
    }

    @GetMapping("/film/actorname/{name}")
    public ResponseEntity<?> findFilmByActor(@PathVariable("name")String fname,@PathVariable("name")String lname){
        return filmService.getFilmByActor(fname,lname);
    }



    // update actor Rest API
    @PutMapping(value = "/film/{id}")
    public ResponseEntity<Film> editCountry(@PathVariable("id") int id,@RequestBody() Film film){
        return filmService.updateFilm(id,film);
    }

    // delete actor from rest API
    @DeleteMapping(value = "/film/{id}")
    public ResponseEntity<HttpStatus> deleteCountry(@PathVariable("id")int id){
        return filmService.removeFilm(id);
    }
}
