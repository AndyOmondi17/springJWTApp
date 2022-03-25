package com.andy.springapp.service;;

import com.andy.springapp.model.Actor;
import com.andy.springapp.repo.ActorRepo;
import com.andy.springapp.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class ActorService {

    @Autowired
    private ActorRepo actorRepo;


    public ActorService(ActorRepo actorRepo) {
        this.actorRepo = actorRepo;
    }

    public List<Actor>getActors(){
        return actorRepo.findAll();
    }

    public void addNewActor(Actor actor) {
        actorRepo.save(actor);
    }

    public ResponseEntity<Actor> getActorById(@PathVariable int id){
        Actor actor=actorRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Actor not exist with id:" + id));
        return ResponseEntity.ok(actor);
    }

    public ResponseEntity<Actor> updateActor(@PathVariable int id,@RequestBody Actor actorDetails){
        Actor actor=actorRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Actor not exist with id:" + id));

        actorDetails.setFirstName(actor.getFirstName());
        actor.setLastName(actor.getLastName());


        actorRepo.save(actorDetails);
        return ResponseEntity.ok(actor);
    }

    public  ResponseEntity<HttpStatus> removeActor(@PathVariable int id){
        Actor actor=actorRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Actor not exist with id:" + id));
        actorRepo.delete(actor);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
