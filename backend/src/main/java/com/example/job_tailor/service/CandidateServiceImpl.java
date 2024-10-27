package com.example.job_tailor.service;


import com.example.job_tailor.model.Candidate;
import com.example.job_tailor.repository.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepo candidateRepo;

    public CandidateServiceImpl(CandidateRepo candidateRepo){
        this.candidateRepo = candidateRepo;
    }
    @Override
    public Candidate createCandidate(Candidate candidate){
        Candidate candidate1 = new Candidate();
        candidate1.setFirstName(candidate.getFirstName());
//        candidate1.setMiddleName("jane");
        candidate1.setLastName(candidate.getLastName());
        candidateRepo.save(candidate1);
        return candidate1;
    }


    @Override
    public Candidate getCandidate(Long id) {
       return candidateRepo.findById(id).orElse(null);
    }
}
