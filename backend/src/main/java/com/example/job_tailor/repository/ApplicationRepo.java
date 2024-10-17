package com.example.job_tailor.repository;

import com.example.job_tailor.api.entity.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

//needs change, look at Pagination
@CrossOrigin("http://localhost:8080")
public interface ApplicationRepo extends CrudRepository<Application, Long> {
}
