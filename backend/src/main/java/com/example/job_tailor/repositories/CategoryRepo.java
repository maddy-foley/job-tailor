package com.example.job_tailor.repositories;

import com.example.job_tailor.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:8080")
public interface CategoryRepo extends CrudRepository<CategoryEntity, Long> {
}
