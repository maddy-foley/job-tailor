package com.example.job_tailor.user.controller;

import com.example.job_tailor.user.model.Experience;
import com.example.job_tailor.user.service.ExperienceService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExperienceController {

    @Autowired
    public ExperienceService experienceService;
    public ExperienceController(){ this.experienceService = experienceService; }
    @PostMapping("public/candidate/{id}/experience")
    public ResponseEntity<Experience> createExperience(@PathVariable("id") Long id, @RequestBody Experience experience){
        Experience e = experienceService.createExperience(id, experience);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @GetMapping("public/candidate/{id}/experience")
    public ResponseEntity<Set<Experience>> getCandidateExperience(@PathVariable("id") Long id){
       Set<Experience> experiences = experienceService.getCandidateExperience(id);

        return new ResponseEntity<>(experiences,HttpStatus.OK);
    }


}
