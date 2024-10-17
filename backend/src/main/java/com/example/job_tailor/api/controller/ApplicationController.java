package com.example.job_tailor.api.controller;

import com.example.job_tailor.api.entity.Application;
import com.example.job_tailor.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    private ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService){
        this.applicationService = applicationService;
    }

    @GetMapping
    public Application getApplication(@RequestParam Integer id){
        return applicationService.getApplication(id);
    }
}
