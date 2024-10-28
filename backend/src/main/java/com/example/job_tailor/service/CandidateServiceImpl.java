package com.example.job_tailor.service;


import com.example.job_tailor.dto.CreateCandidateDto;
import com.example.job_tailor.model.Address;
import com.example.job_tailor.model.Candidate;
import com.example.job_tailor.repository.AddressRepo;
import com.example.job_tailor.repository.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Candidate createCandidate(CreateCandidateDto userInfo){
        Candidate c = new Candidate();
        Address a = new Address();
        System.out.println(userInfo);

        c.setFirstName(userInfo.getCandidate().getFirstName());
        c.setLastName(userInfo.getCandidate().getLastName());
        candidateRepo.save(c);

        a.setCandidate(c);
        a.setPhone(userInfo.getAddress().getPhone());
        a.setEmail(userInfo.getAddress().getEmail());
        a.setStreetAddress(userInfo.getAddress().getStreetAddress());
        a.setCity(userInfo.getAddress().getCity());
        a.setState(userInfo.getAddress().getState());
        a.setZipCode(userInfo.getAddress().getZipCode());
        a.setCountry(userInfo.getAddress().getCountry());
        a.setUrls(userInfo.getAddress().getUrls());
        addressRepo.save(a);


        return c;
    }

    @Override
    public Candidate getCandidate(Long id) {
       return candidateRepo.findById(id).orElse(null);
    }

}
