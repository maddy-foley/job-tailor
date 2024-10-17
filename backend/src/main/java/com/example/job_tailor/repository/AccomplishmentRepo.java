package com.example.job_tailor.repository;

import com.example.job_tailor.api.entity.Accomplishment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

//needs change - do we even need an api for this?
@CrossOrigin("http://localhost:8080")
public interface AccomplishmentRepo extends CrudRepository<Accomplishment, Long> {
}
