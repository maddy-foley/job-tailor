package com.example.job_tailor.user.controller;


import com.example.job_tailor.user.dto.CreateCandidateDto;
import com.example.job_tailor.user.dto.CreateCandidateResponse;
import com.example.job_tailor.user.model.Candidate;
import com.example.job_tailor.common.model.Skill;
import com.example.job_tailor.user.model.CandidateSkill;
import com.example.job_tailor.user.service.CandidateService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan
@RestController
@RequestMapping(value = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CandidateController {

    @Autowired
    private CandidateService candidateService;


    public CandidateController(CandidateService candidateService){
        this.candidateService = candidateService;
    }
    //make private
    @GetMapping("public/candidate/{id}")
    public ResponseEntity<Candidate> getCandidate(@PathVariable("id") Long id) {
        Candidate c = candidateService.getCandidate(id);

        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PostMapping("public/candidate/new")
    public ResponseEntity<CreateCandidateResponse> createCandidate(@RequestBody CreateCandidateDto candidateInfo){
        CreateCandidateResponse res = candidateService.createCandidate(candidateInfo);

        if(res == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
//    @PostMapping("public/candidate/{id}/skills")
//    public ResponseEntity<String> addCandidateSkills(@PathVariable("id") Long id,@NonNull List<CandidateSkill> candidateSkills){
//        String res = candidateService.addCandidateSkills(id, candidateSkills);
//
//        if(res == null){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        return new ResponseEntity<>(res, HttpStatus.OK);
//    }
    @GetMapping("public/candidate/all")
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        List<Candidate> c = candidateService.getAllCandidates();

        return new ResponseEntity<>(c, HttpStatus.OK);
    }

}


