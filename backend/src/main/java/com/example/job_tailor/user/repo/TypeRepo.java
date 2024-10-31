package com.example.job_tailor.user.repo;

import com.example.job_tailor.user.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:8080")
//@RepositoryRestResource(collectionResourceRel = "type", path = "type")
public interface TypeRepo extends JpaRepository<Type, Long> {
}
