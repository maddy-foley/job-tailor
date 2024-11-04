package com.example.job_tailor.common.service;

import com.example.job_tailor.common.model.Category;
import com.example.job_tailor.common.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    CategoryServiceImpl(CategoryRepo categoryRepo){ this.categoryRepo = categoryRepo; }
    @Override
    public List<Category> getAllCategories(){
        return categoryRepo.findAll();
    }

    @Override
    public Category createCategory(Category category){
        Category findCategory = categoryRepo.findByName(category.getName());
        if(findCategory == null){
            return categoryRepo.save(category);
        }
        else {
            return null;
        }
    }
    //FIX
    @Override
    public Boolean deleteCategory(Long id){
        categoryRepo.deleteById(id);
        return true;
    }

}
