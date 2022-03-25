package com.andy.springapp.ApiControllers;


import com.andy.springapp.model.Actor;
import com.andy.springapp.service.ActorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ActorController {

    @Autowired
    private ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    // get all actors
    @GetMapping(value = "/actors")
    public List<Actor> getAllActors(){
        return actorService.getActors();
    }

//    I can't post an actor
    //create actor for api
    @PostMapping("/actors")
    public void createActor(@RequestBody Actor actor){
        actorService.addNewActor(actor);
    }

//    get actor by id
    @GetMapping(value = "/actors/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable("id")Integer id){
        return actorService.getActorById(id);
    }

    // update actor Rest API
    @PutMapping(value = "/actors/{id}")
   public ResponseEntity<Actor> editActor(@PathVariable("id") int id,@RequestBody() Actor actor){
        return actorService.updateActor(id,actor);
    }

    // delete actor from rest API
    @DeleteMapping(value = "/actors/{id}")
    public ResponseEntity<HttpStatus> deleteActor(@PathVariable("id")int id){
       return actorService.removeActor(id);
    }

}
