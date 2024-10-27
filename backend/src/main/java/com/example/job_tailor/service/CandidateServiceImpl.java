package com.example.job_tailor.service;


import com.example.job_tailor.model.Candidate;
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
    @Override
    public Candidate createCandidate(Candidate candidate){
        Candidate c = new Candidate();
        c.setFirstName(candidate.getFirstName());
//        candidate1.setMiddleName("jane");
        c.setLastName(candidate.getLastName());
        candidateRepo.save(c);
        return c;
    }


    @Override
    public Candidate getCandidate(Long id) {
       return candidateRepo.findById(id).orElse(null);
    }
}
