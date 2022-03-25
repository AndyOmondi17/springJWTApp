package com.andy.springapp.repo;


import com.andy.springapp.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepo extends JpaRepository<Language,Integer> {

}
