package com.example.job_tailor.repositories;

import com.example.job_tailor.entities.AddressEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

//needs change
@CrossOrigin("http://localhost:8080/address")
public interface AddressRepo extends CrudRepository<AddressEntity, Long> {
}
