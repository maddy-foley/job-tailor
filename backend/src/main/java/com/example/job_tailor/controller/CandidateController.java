package com.example.job_tailor.controller;


import com.example.job_tailor.model.Candidate;
import com.example.job_tailor.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//
//@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    public CandidateController(CandidateService candidateService){
        this.candidateService = candidateService;
    }
//    NEEDS TO BE REMOVED

//    @GetMapping("/all")
//    public ResponseEntity<List<Candidate>> getAllCandidates(){
//        List<Candidate> allCandidates = candidateService.getAllCandidates();
//        System.out.println();
//    }

    @PostMapping("/new")
    public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate){
            Candidate createdCandidate = candidateService.createCandidate(candidate);
            if (createdCandidate == null) {
                return ResponseEntity.notFound().build();
            } else {
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(candidate.getCandidateID())
                        .toUri();

                return ResponseEntity.created(uri)
                        .body(createdCandidate);
            }
    }


}
