package com.example.job_tailor.repository;

import com.example.job_tailor.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

//needs change
@CrossOrigin("http://localhost:8080")
public interface AddressRepo extends CrudRepository<Address, Long> {
}
