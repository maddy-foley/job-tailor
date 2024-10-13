package com.example.job_tailor.repositories;

import com.example.job_tailor.entities.ApplicationEntity;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepo extends CrudRepository<ApplicationEntity, Long> {
}
