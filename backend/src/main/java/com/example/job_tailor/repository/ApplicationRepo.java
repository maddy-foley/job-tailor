package com.example.job_tailor.repository;

import com.example.job_tailor.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

//needs change, look at Pagination
//@CrossOrigin("http://localhost:8080")
//@RepositoryRestResource(collectionResourceRel = "application", path = "application")
@Repository
public interface ApplicationRepo extends JpaRepository<Application, Long> {
}
