package com.example.job_tailor.service;

import com.example.job_tailor.repository.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepo candidateRepo;

    public CandidateServiceImpl(CandidateRepo candidateRepo){
        this.candidateRepo = candidateRepo;
    }

//    @Override
//    public Candidate getCandidate() {
//        return new Candidate();
//    }
}
