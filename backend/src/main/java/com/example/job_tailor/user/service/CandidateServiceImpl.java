package com.example.job_tailor.user.service;


import com.example.job_tailor.common.repo.SkillRepo;
import com.example.job_tailor.user.dto.CreateCandidateDto;
import com.example.job_tailor.user.dto.CreateCandidateResponse;
import com.example.job_tailor.user.model.Address;
import com.example.job_tailor.user.model.Candidate;
import com.example.job_tailor.common.model.Skill;
import com.example.job_tailor.user.model.CandidateSkill;
import com.example.job_tailor.user.repo.AddressRepo;
import com.example.job_tailor.user.repo.CandidateRepo;
import com.example.job_tailor.user.repo.CandidateSkillRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepo candidateRepo;

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    CandidateSkillRepo candidateSkillRepo;

    @Autowired
    SkillRepo skillRepo;

    public CandidateServiceImpl(CandidateRepo candidateRepo, AddressRepo addressRepo, CandidateSkillRepo candidateSkillRepo,SkillRepo skillRepo){
        this.addressRepo = addressRepo;
        this.candidateRepo = candidateRepo;
        this.candidateSkillRepo = candidateSkillRepo;
        this.skillRepo = skillRepo;
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
        Optional<Candidate> c = candidateRepo.findById(candidateID);
        if(c.isPresent()){
            for(Skill skill : skills){
                Skill skill1 = findSkill(skill);
                CandidateSkill cs = new CandidateSkill();
                cs.setCandidateSkillID(candidateID);
                cs.getCandidateSkillID(skill1.getSkillID());
            }
        } else {
            return "Error";
        }
    }

    private Skill findSkill(Skill skill){
        Skill s = skillRepo.findByName(skill.getName());
        if (s == null){
            Skill skill1 = new Skill();
            skill1.setName(skill.getName());
            skillRepo.save(skill1);
            return skill1;
        } else {
            return s;
        }
    }
}
