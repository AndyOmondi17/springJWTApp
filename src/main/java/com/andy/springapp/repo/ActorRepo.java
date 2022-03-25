package com.andy.springapp.repo;


import com.andy.springapp.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActorRepo extends JpaRepository<Actor,Integer> {
}
