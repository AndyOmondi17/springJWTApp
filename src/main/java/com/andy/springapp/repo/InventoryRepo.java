package com.andy.springapp.repo;


import com.andy.springapp.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InventoryRepo extends JpaRepository<Inventory,Integer> {

}
