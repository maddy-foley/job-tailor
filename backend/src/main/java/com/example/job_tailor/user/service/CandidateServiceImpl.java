package com.example.job_tailor.user.service;


import com.example.job_tailor.user.dto.CreateCandidateDto;
import com.example.job_tailor.user.dto.CreateCandidateResponse;
import com.example.job_tailor.user.model.Address;
import com.example.job_tailor.user.model.Candidate;
import com.example.job_tailor.common.model.Skill;
import com.example.job_tailor.user.repo.AddressRepo;
import com.example.job_tailor.user.repo.CandidateRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepo candidateRepo;

    @Autowired
    private AddressRepo addressRepo;

    public CandidateServiceImpl(CandidateRepo candidateRepo, AddressRepo addressRepo){
        this.addressRepo = addressRepo;
        this.candidateRepo = candidateRepo;
    }
    @Override
    @Transactional
    public CreateCandidateResponse createCandidate(CreateCandidateDto candidateInfo){

        Candidate c = new Candidate(candidateInfo.getFirstName(), candidateInfo.getLastName());
        candidateRepo.save(c);

        Address a = new Address(
                candidateInfo.getEmail(),
                candidateInfo.getPhone(),
                candidateInfo.getCity(),
                candidateInfo.getZipCode(),
                candidateInfo.getCountry(),
                candidateInfo.getState(),
                c,
                candidateInfo.getStreetAddress()
                );
        addressRepo.save(a);

        //ensure both have been saved
        CreateCandidateResponse res = new CreateCandidateResponse();
        res.setFirstName(c.getFirstName());

        return res;
    }

    @Override
    public Candidate getCandidate(Long id) {
       return candidateRepo.findById(id).orElse(null);
    }

    @Override
    public String addCandidateSkills(Long candidateID,List<Skill> skills){
//        Candidate c = candidateRepo.findById(candidateID);
        return "";
    }

}
