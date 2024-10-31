package com.example.job_tailor.common.repo;

import com.example.job_tailor.common.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:8080")
//@RepositoryRestResource(collectionResourceRel = "url", path = "address")
public interface UrlRepo extends JpaRepository<Url, Long> {
}
