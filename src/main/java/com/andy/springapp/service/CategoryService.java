package com.andy.springapp.service;;

import com.andy.springapp.model.Category;
import com.andy.springapp.repo.CategoryRepo;
import com.andy.springapp.exception.ResourceNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;


    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Category> getCategory(){
        return categoryRepo.findAll();
    }

    public void addNewCategory(Category category) {
        categoryRepo.save(category);
    }

    public ResponseEntity<Category> getCategoryById(@PathVariable int id){
        Category category= categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category not exist with id:" + id));
        return ResponseEntity.ok(category);
    }

    public ResponseEntity<Category> updateCategory(@PathVariable int id,@RequestBody Category categoryDetails){
        Category category= categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category not exist with id:" + id));
        categoryDetails.setName(category.getName());
        categoryRepo.save(categoryDetails);
        return ResponseEntity.ok(category);
    }

    public  ResponseEntity<HttpStatus> removeCategory(@PathVariable int id){
        Category category= categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Address not exist with id:" + id));
        categoryRepo.delete(category);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
