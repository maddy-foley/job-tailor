package com.example.job_tailor.user.service;


import com.example.job_tailor.common.repo.SkillRepo;
import com.example.job_tailor.user.dto.AddCandidateSkillDto;
import com.example.job_tailor.user.dto.CreateCandidateDto;
import com.example.job_tailor.user.dto.response.AddCandidateSkillResponse;
import com.example.job_tailor.user.dto.response.CreateCandidateResponse;
import com.example.job_tailor.user.dto.response.GetCandidateByIdResponse;
import com.example.job_tailor.user.model.Address;
import com.example.job_tailor.user.model.Candidate;
import com.example.job_tailor.common.model.Skill;
import com.example.job_tailor.user.model.CandidateSkill;
import com.example.job_tailor.user.repo.AddressRepo;
import com.example.job_tailor.user.repo.CandidateRepo;
import com.example.job_tailor.user.repo.CandidateSkillRepo;
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
    private CandidateSkillRepo candidateSkillRepo;

    @Autowired
    private SkillRepo skillRepo;

    public CandidateServiceImpl(CandidateRepo candidateRepo, CandidateSkillRepo candidateSkillRepo,SkillRepo skillRepo, AddressRepo addressRepo){
        this.candidateRepo = candidateRepo;
        this.candidateSkillRepo = candidateSkillRepo;
        this.skillRepo = skillRepo;
        this.addressRepo = addressRepo;
    }
    @Override
    public CreateCandidateResponse createCandidate(CreateCandidateDto candidateInfo){
        Address a = new Address(
                candidateInfo.getEmail(),
                candidateInfo.getPhone(),
                candidateInfo.getCity(),
                candidateInfo.getZipCode(),
                candidateInfo.getCountry(),
                candidateInfo.getState(),
                candidateInfo.getStreetAddress()
        );
        addressRepo.save(a);
        Candidate c = new Candidate(candidateInfo.getFirstName(), candidateInfo.getLastName(),a);
        candidateRepo.save(c);
        //ensure both have been saved
        CreateCandidateResponse res = new CreateCandidateResponse(c.getFirstName());
        return res;
    }

    @Override
    public GetCandidateByIdResponse getCandidate(Long id) {
        GetCandidateByIdResponse res = new GetCandidateByIdResponse();
        Candidate c = candidateRepo.findById(id).orElse(null);
        System.out.println(c);
        if (c == null){
            return null;

        }
        res.setFirstName(c.getFirstName());
        res.setLastName(c.getLastName());
        res.setAddress(c.getAddress());
        return res;
    }
    @Override
    public AddCandidateSkillResponse addCandidateSkill(Long id, Long skill_id, AddCandidateSkillDto candidateSkillDto){
        Candidate c = candidateRepo.findById(id).orElse(null);
        Skill s = skillRepo.findBySkillId(skill_id);
        if(c == null || s == null){
            return null;
        }
        CandidateSkill cs = new CandidateSkill();
        cs.setSkill(s);
        cs.setCandidate(c);
        cs.setAbility(candidateSkillDto.getAbility());
        cs.setYearsOfExperience(candidateSkillDto.getYearsOfExperience());
        candidateSkillRepo.save(cs);

        AddCandidateSkillResponse res = new AddCandidateSkillResponse(cs.getSkill().getName(), cs.getAbility(), cs.getYearsOfExperience(),cs.getSkill().getCategories());
        return res;
    }


//    @Override
//    public String addCandidateSkills(Long id,List<CandidateSkill> candidateSkills){
//        Candidate c = getCandidate(id);
//        if(c != null){
//            for(CandidateSkill skill : candidateSkills){
//                Skill foundSkill = skill.getSkill();
//                CandidateSkill cs = new CandidateSkill();
//                candidateSkillRepo.save(skill);
//            }
//        } else {
//        return "Error";
//        }
//        return "worked";
//    }

//    private Skill findOrAddSkill(Skill skill){
//        Skill s = skillRepo.findByName(skill.getName());
//        if (s == null){
//            Skill skill1 = new Skill();
//            skill1.setName(skill.getName());
//            skillRepo.save(skill1);
//            return skill1;
//        } else {
//            return s;
//        }
//    }

    @Override
    public List<Candidate> getAllCandidates(){
        return (List<Candidate>) candidateRepo.findAll();
    }
}
