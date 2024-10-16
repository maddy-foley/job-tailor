package com.example.job_tailor.repositories;

import com.example.job_tailor.entities.SkillEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:8080")
public interface SkillRepo extends CrudRepository<SkillEntity, Long> {
}
