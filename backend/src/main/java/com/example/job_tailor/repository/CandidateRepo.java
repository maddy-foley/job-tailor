package com.example.job_tailor.repository;

import com.example.job_tailor.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:8080")
@RepositoryRestResource(collectionResourceRel = "candidate", path = "candidate")
public interface CandidateRepo extends CrudRepository<Candidate, Long> {
}
