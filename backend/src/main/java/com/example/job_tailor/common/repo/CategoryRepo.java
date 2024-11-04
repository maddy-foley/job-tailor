package com.example.job_tailor.common.repo;

import com.example.job_tailor.common.model.Category;
import com.example.job_tailor.common.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:8080")
//@RepositoryRestResource(collectionResourceRel = "category", path = "category")
public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
