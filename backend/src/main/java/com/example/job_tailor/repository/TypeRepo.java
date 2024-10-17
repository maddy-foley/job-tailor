package com.example.job_tailor.repository;

import com.example.job_tailor.api.entity.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:8080")
public interface TypeRepo extends CrudRepository<Type, Long> {
}
