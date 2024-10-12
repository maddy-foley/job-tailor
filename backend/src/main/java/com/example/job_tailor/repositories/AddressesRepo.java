package com.example.job_tailor.repositories;

import com.example.job_tailor.entities.AddressEntity;
import org.springframework.data.repository.CrudRepository;

public interface AddressesRepo extends CrudRepository<AddressEntity, Long> {
}
