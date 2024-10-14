package com.example.job_tailor.repositories;

import com.example.job_tailor.entities.ApplicationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

//needs change, look at Pagination
@CrossOrigin("http://localhost:8080")
public interface ApplicationRepo extends CrudRepository<ApplicationEntity, Long> {
}
