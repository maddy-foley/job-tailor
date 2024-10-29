package com.example.job_tailor.service;


import com.example.job_tailor.dto.CreateCandidateDto;
import com.example.job_tailor.dto.CreateCandidateResponse;
import com.example.job_tailor.model.Address;
import com.example.job_tailor.model.Application;
import com.example.job_tailor.model.Candidate;
import com.example.job_tailor.repository.AddressRepo;
import com.example.job_tailor.repository.CandidateRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


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

}
