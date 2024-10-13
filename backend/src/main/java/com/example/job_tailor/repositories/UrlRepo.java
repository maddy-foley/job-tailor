package com.example.job_tailor.repositories;

import com.example.job_tailor.entities.UrlEntity;
import org.springframework.data.repository.CrudRepository;

public interface UrlRepo extends CrudRepository<UrlEntity, Long> {
}
