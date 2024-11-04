package com.example.job_tailor.common.controller;

import com.example.job_tailor.common.model.Category;
import com.example.job_tailor.common.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan
@RestController
@RequestMapping(value = "api",produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService){ this.categoryService  = categoryService; }

    @GetMapping("/public/category/all")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = categoryService.getAllCategories();
        if(categories == null){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @PostMapping("/public/category/new")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        Category createdCategory = categoryService.createCategory(category);

        if(createdCategory == null ){
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(createdCategory, HttpStatus.OK);
        }
    }

    //FIX
    @DeleteMapping("/public/category/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") Long id){
        boolean isDeleted = categoryService.deleteCategory(id);

        return new ResponseEntity<>(isDeleted,HttpStatus.OK);
    }
}
