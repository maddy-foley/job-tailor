package com.example.job_tailor.repository;

import com.example.job_tailor.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin("http://localhost:8080")
//@RepositoryRestResource(collectionResourceRel = "experience", path = "experience")
public interface ExperienceRepo extends JpaRepository<Experience, Long> {
}
