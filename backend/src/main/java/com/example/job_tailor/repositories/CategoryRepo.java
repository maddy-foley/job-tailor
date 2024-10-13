package com.example.job_tailor.repositories;

import com.example.job_tailor.entities.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<CategoryEntity, Long> {
}
