package com.example.job_tailor.repository;

import com.example.job_tailor.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin("http://localhost:8080")
//@RepositoryRestResource(collectionResourceRel = "category", path = "category")
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
