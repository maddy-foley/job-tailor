package com.example.job_tailor.application.repo;


import com.example.job_tailor.application.model.ApplicationSkill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:8080")
@RepositoryRestResource(collectionResourceRel = "application_skill", path = "application_skill")
public interface ApplicationSkillRepo extends CrudRepository<ApplicationSkill, Long> {
}
