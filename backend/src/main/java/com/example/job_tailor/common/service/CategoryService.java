package com.example.job_tailor.common.service;

import com.example.job_tailor.common.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category createCategory(Category category);
}
