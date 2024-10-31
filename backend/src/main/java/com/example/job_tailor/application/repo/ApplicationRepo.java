package com.example.job_tailor.application.repo;

import com.example.job_tailor.application.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//needs change, look at Pagination
//@CrossOrigin("http://localhost:8080")
//@RepositoryRestResource(collectionResourceRel = "application", path = "application")
@Repository
public interface ApplicationRepo extends JpaRepository<Application, Long> {
}
