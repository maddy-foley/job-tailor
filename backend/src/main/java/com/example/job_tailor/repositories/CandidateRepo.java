package com.example.job_tailor.repositories;

import com.example.job_tailor.entities.CandidateEntity;
import org.springframework.data.repository.CrudRepository;


public interface CandidateRepo extends CrudRepository<CandidateEntity, Long> {
}
