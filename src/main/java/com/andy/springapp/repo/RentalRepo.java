package com.andy.springapp.repo;


import com.andy.springapp.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepo extends JpaRepository<Rental,Integer> {

}
