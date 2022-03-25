package com.andy.springapp.repo;


import com.andy.springapp.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepo extends JpaRepository<Country,Integer> {

}
