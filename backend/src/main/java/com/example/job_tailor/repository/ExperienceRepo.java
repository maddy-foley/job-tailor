package com.example.job_tailor.repository;

import com.example.job_tailor.api.entity.Experience;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:8080")
public interface ExperienceRepo extends CrudRepository<Experience, Long> {
}