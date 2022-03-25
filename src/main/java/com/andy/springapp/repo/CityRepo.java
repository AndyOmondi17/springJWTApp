package com.andy.springapp.repo;


import com.andy.springapp.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends JpaRepository<City,Integer> {

}
