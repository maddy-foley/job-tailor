package com.example.job_tailor.controller;


import com.example.job_tailor.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService){
        this.applicationService = applicationService;
    }

//    @GetMapping
//    public Application getApplication(@RequestParam Integer id){
//        return applicationService.getApplication(id);
//    }
}
