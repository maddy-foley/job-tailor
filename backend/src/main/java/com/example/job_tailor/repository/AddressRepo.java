package com.example.job_tailor.repository;

import com.example.job_tailor.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//needs change
//@CrossOrigin("http://localhost:8080")
//@RepositoryRestResource(collectionResourceRel = "address", path = "address")
public interface AddressRepo extends JpaRepository<Address, Long> {
}
