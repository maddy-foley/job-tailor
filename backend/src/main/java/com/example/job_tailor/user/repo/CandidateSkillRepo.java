package com.example.job_tailor.user.repo;

import com.example.job_tailor.user.model.CandidateSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:8080")
@RepositoryRestResource(collectionResourceRel = "candidate_skill", path = "candidate_skill")
public interface CandidateSkillRepo extends JpaRepository<CandidateSkill, Long> {
}
