package com.example.job_tailor.user.controller;


import com.example.job_tailor.common.model.Skill;
import com.example.job_tailor.user.dto.AddCandidateSkillDto;
import com.example.job_tailor.user.dto.CreateCandidateDto;
import com.example.job_tailor.user.dto.response.AddCandidateSkillResponse;
import com.example.job_tailor.user.dto.response.CreateCandidateResponse;
import com.example.job_tailor.user.dto.response.GetCandidateByIdResponse;
import com.example.job_tailor.user.model.Candidate;
import com.example.job_tailor.user.model.CandidateSkill;
import com.example.job_tailor.user.service.CandidateService;
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
    // WORKING
    @GetMapping("public/candidate/{id}")
    public ResponseEntity<GetCandidateByIdResponse> getCandidate(@PathVariable("id") Long id) {
        GetCandidateByIdResponse c = candidateService.getCandidate(id);

        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    //FIX
    @PostMapping("public/candidate/new")
    public ResponseEntity<CreateCandidateResponse> createCandidate(@RequestBody CreateCandidateDto candidateInfo){
        CreateCandidateResponse res = candidateService.createCandidate(candidateInfo);

        if(res == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PostMapping("public/candidate/{id}/skill/{skill_id}")
    public ResponseEntity<AddCandidateSkillResponse> addCandidateSkill(@PathVariable("id") Long id, @PathVariable("skill_id") Long skill_id, @RequestBody AddCandidateSkillDto candidateSkillDto){
        AddCandidateSkillResponse cs = candidateService.addCandidateSkill(id,skill_id, candidateSkillDto);
        if(cs == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(cs, HttpStatus.OK);
    }
    //WORKING
    @GetMapping("public/candidate/all")
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        List<Candidate> c = candidateService.getAllCandidates();

        return new ResponseEntity<>(c, HttpStatus.OK);
    }

//    @PutMapping("public/candidate/{id}")
//    public ResponseEntity<Candidate> updateCandidate(@PathVariable("id") Long id){
//        Candidate c = candidateService.updateCandidate();
//    }

}


