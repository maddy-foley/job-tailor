package com.example.job_tailor.user.repo;

import com.example.job_tailor.user.model.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:8080")
@RepositoryRestResource(collectionResourceRel = "candidate", path = "candidate")
public interface CandidateRepo extends CrudRepository<Candidate, Long> {
}
