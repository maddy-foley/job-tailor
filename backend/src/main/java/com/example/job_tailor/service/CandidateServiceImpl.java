package com.example.job_tailor.service;

import com.example.job_tailor.model.Candidate;
import com.example.job_tailor.repository.CandidateRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        candidate1.setFirstName("maddy");
//        candidate1.setMiddleName("jane");
        candidate1.setLastName("foley");
        candidateRepo.save(candidate1);
        return candidate1;
    }

//    @Override
//    public List<Candidate> getAllCandidates(){
//        List<Candidate> c = candidateRepo.findAll();
//        return c;
//    }
}
