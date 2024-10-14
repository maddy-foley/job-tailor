package com.example.job_tailor.repositories;

import com.example.job_tailor.entities.UrlEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:8080/url")
public interface UrlRepo extends CrudRepository<UrlEntity, Long> {
}
