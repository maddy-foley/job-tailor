package com.example.job_tailor.controller;


import com.example.job_tailor.dto.CreateCandidateDto;
import com.example.job_tailor.model.Candidate;
import com.example.job_tailor.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/candidate",produces = MediaType.APPLICATION_JSON_VALUE)
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    public CandidateController(CandidateService candidateService){
        this.candidateService = candidateService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Candidate> getCandidate(@PathVariable("id") Long id) {
        Candidate c = candidateService.getCandidate(id);

        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Candidate> createCandidate(@RequestBody CreateCandidateDto userInfo){
            Candidate createdCandidate = candidateService.createCandidate(userInfo);
            if (createdCandidate == null) {
                return ResponseEntity.notFound().build();
            } else {
                return new ResponseEntity<>(createdCandidate, HttpStatus.OK);
            }
    }

//    @PostMapping("/{id}/address")
//    public ResponseEntity<Candidate> createCandidate(@PathVariable("id") Long id){
//        if (createdCandidate == null) {
//            return ResponseEntity.notFound().build();
//        } else {
//            System.out.println(candidate);
//            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                    .path("/{id}")
//                    .buildAndExpand(candidate.getCandidateID())
//                    .toUri();
//
//            return ResponseEntity.created(uri)
//                    .body(createdCandidate);
//        }
//    }

}
