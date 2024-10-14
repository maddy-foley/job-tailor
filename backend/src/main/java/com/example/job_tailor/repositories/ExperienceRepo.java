package com.example.job_tailor.repositories;

import com.example.job_tailor.entities.ExperienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:8080/experience")
public interface ExperienceRepo extends CrudRepository<ExperienceEntity, Long> {
}
