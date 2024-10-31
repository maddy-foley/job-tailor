package com.example.job_tailor.user.repo;

import com.example.job_tailor.user.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:8080")
//@RepositoryRestResource(collectionResourceRel = "experience", path = "experience")
public interface ExperienceRepo extends JpaRepository<Experience, Long> {
}
