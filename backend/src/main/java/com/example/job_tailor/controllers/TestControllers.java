package com.example.job_tailor.controllers;

import com.example.job_tailor.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TestControllers {

    @Autowired
    AccomplishmentRepo accomplishmentRepo;

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    ApplicationContext context;

    @Autowired
    CandidateRepo candidateRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ExperienceRepo experienceRepo;

    @Autowired
    SkillRepo skillRepo;

   @Autowired
    TypeRepo typeRepo;

   @Autowired
    UrlRepo urlRepo;


}
