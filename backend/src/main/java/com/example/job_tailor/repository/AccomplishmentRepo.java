package com.example.job_tailor.repository;

import com.example.job_tailor.model.Accomplishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

//needs change - do we even need an api for this?
//@CrossOrigin("http://localhost:8080")
//@RepositoryRestResource(collectionResourceRel = "accomplishment", path = "accomplishment")
//@Repository
public interface AccomplishmentRepo extends JpaRepository<Accomplishment, Long> {
}
