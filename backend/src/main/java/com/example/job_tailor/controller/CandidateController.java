package com.example.job_tailor.controller;


import com.example.job_tailor.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/api/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    public CandidateController(CandidateService candidateService){
        this.candidateService = candidateService;
    }
    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello, World";
    }

}
