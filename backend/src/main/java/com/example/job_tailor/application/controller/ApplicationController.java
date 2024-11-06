package com.example.job_tailor.application.controller;

import com.example.job_tailor.application.model.Application;
import com.example.job_tailor.application.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ComponentScan
@RestController
@RequestMapping(value = "api",produces = MediaType.APPLICATION_JSON_VALUE)
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    ApplicationController(ApplicationService applicationService){ this.applicationService = applicationService; }

    @PostMapping("public/candidate/{id}/application/new")
    public ResponseEntity<Application> createApplication(@PathVariable("id") Long id, @RequestBody Application application){
        Application app = applicationService.createApplication(id,application);

        if (app == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(app, HttpStatus.OK);
    }

}
