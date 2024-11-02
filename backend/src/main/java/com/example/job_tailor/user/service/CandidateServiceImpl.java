package com.example.job_tailor.user.service;


import com.example.job_tailor.common.repo.SkillRepo;
import com.example.job_tailor.user.dto.CreateCandidateDto;
import com.example.job_tailor.user.dto.CreateCandidateResponse;
import com.example.job_tailor.user.model.Address;
import com.example.job_tailor.user.model.Candidate;
import com.example.job_tailor.common.model.Skill;
import com.example.job_tailor.user.model.CandidateSkill;
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
    CandidateSkillRepo candidateSkillRepo;

    @Autowired
    SkillRepo skillRepo;

    public CandidateServiceImpl(CandidateRepo candidateRepo, CandidateSkillRepo candidateSkillRepo,SkillRepo skillRepo){
        this.candidateRepo = candidateRepo;
        this.candidateSkillRepo = candidateSkillRepo;
        this.skillRepo = skillRepo;
    }
    @Override
    @Transactional
    public CreateCandidateResponse createCandidate(CreateCandidateDto candidateInfo){

        Candidate c = new Candidate(candidateInfo.getFirstName(), candidateInfo.getLastName());


        Address a = new Address(
                candidateInfo.getEmail(),
                candidateInfo.getPhone(),
                candidateInfo.getCity(),
                candidateInfo.getZipCode(),
                candidateInfo.getCountry(),
                candidateInfo.getState(),
                candidateInfo.getStreetAddress()
                );
        c.setAddress(a);
        candidateRepo.save(c);

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
    public String addCandidateSkills(Long id,List<Skill> skills){
        Candidate c = getCandidate(id);
        if(c != null){
            for(Skill skill : skills){
                Skill foundSkill = findOrAddSkill(skill);
                CandidateSkill cs = new CandidateSkill();
                cs.setSkill(foundSkill);
                candidateSkillRepo.save(cs);
            }
        } else {
        return "Error";
        }
        return "worked";
    }

    private Skill findOrAddSkill(Skill skill){
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
