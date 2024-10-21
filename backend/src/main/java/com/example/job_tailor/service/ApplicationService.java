package com.example.job_tailor.service;

import com.example.job_tailor.model.Application;
import com.example.job_tailor.repository.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
    private ApplicationRepo applicationRepo;

    @Autowired
    public ApplicationService(ApplicationRepo applicationRepo){
        this.applicationRepo = applicationRepo;
    }

    public ResponseEntity<Object> newApplication(Application application) {
        applicationRepo.save(application);
        return new ResponseEntity<>(application, HttpStatus.CREATED);
    }
}
