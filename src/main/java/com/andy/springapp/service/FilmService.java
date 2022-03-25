package com.andy.springapp.service;;

import com.andy.springapp.repo.FilmRepo;
import com.andy.springapp.exception.ResourceNotFoundException;
import com.andy.springapp.model.Film;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepo filmRepo;

    public FilmService(FilmRepo filmRepo) {
        this.filmRepo = filmRepo;
    }

    public List<Film> getFilm(){
        return filmRepo.findAll();
    }

    public void addNewFilm(Film film) {
        filmRepo.save(film);
    }

    public ResponseEntity<Film> getFilmById(@PathVariable int id){
        Film film= filmRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Film not exist with id:" + id));
        return ResponseEntity.ok(film);
    }

    public ResponseEntity<Film> updateFilm(@PathVariable int id,@RequestBody Film filmDetails){
        Film film= filmRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Film not exist with id:" + id));
        filmDetails.setFulltext(film.getFulltext());
        film.setSpecialFeatures(film.getSpecialFeatures());
        film.setRating(film.getRating());
        film.setLength(film.getLength());
        return ResponseEntity.ok(film);
    }


    public ResponseEntity<HttpStatus> removeFilm(@PathVariable int id){
        Film film= filmRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Film not exist with id:" + id));
        filmRepo.delete(film);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<?> getByCategoryName(String category){
              List <Film> film=  filmRepo.findByCategoryName(category);
        return ResponseEntity.ok(film);
    }

    public ResponseEntity<?> getFilmByActor(@PathVariable String firstname,@PathVariable String lastname){
        List<Film> film = filmRepo.findByActor(firstname,lastname);
        return ResponseEntity.ok(film);
    }
}
