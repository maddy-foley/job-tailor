package com.example.job_tailor.common.repo;

import com.example.job_tailor.common.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:8080")
@RepositoryRestResource(collectionResourceRel = "skill", path = "skill")
public interface SkillRepo extends JpaRepository<Skill, Long> {
    Skill findByName(String name);
}
