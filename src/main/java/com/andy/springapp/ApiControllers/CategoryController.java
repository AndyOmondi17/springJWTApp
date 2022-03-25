package com.andy.springapp.ApiControllers;



import com.andy.springapp.model.Category;
import com.andy.springapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // get all actors
    @GetMapping(value = "/category")
    public List<Category> getAllCategories(){
        return categoryService.getCategory();
    }

    //    I can't post an actor
    //create actor for api
    @PostMapping("/category")
    public void createCategory(@RequestBody Category category){
        categoryService.addNewCategory(category);
    }

    //    get actor by id
    @GetMapping(value = "/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id")Integer id){
        return categoryService.getCategoryById(id);
    }

    // update actor Rest API
    @PutMapping(value = "/category/{id}")
    public ResponseEntity<Category> editCategory(@PathVariable("id") int id,@RequestBody() Category category){
        return categoryService.updateCategory(id,category);
    }

    // delete actor from rest API
    @DeleteMapping(value = "/category/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id")int id){
        return categoryService.removeCategory(id);
    }
}
