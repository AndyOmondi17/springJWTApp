package com.andy.springapp.repo;


import com.andy.springapp.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StoreRepo extends JpaRepository<Store,Integer> {

}
