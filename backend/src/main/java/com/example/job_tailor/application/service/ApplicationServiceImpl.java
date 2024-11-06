package com.example.job_tailor.application.service;

import com.example.job_tailor.application.model.Application;
import com.example.job_tailor.application.model.EnumStatus;
import com.example.job_tailor.application.repo.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService{

    @Autowired
    ApplicationRepo applicationRepo;

    ApplicationServiceImpl(ApplicationRepo applicationRepo){this.applicationRepo = applicationRepo;}

    public Application createApplication(Long id, Application application){
        application.setCandidateId(id);
        application.setStatus(EnumStatus.Applying);
        return applicationRepo.save(application);
    }
}
