package com.example.job_tailor.user.service;

import com.example.job_tailor.user.dto.response.ExperienceResponse;
import com.example.job_tailor.user.model.Candidate;
import com.example.job_tailor.user.model.Experience;
import com.example.job_tailor.user.repo.CandidateRepo;
import com.example.job_tailor.user.repo.ExperienceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExperienceServiceImpl implements ExperienceService{

    @Autowired
    private ExperienceRepo experienceRepo;

    @Autowired
    private CandidateRepo candidateRepo;

    ExperienceServiceImpl(ExperienceRepo experienceRepo, CandidateRepo candidateRepo){
        this.experienceRepo = experienceRepo;
        this.candidateRepo = candidateRepo;
    }

    @Override
    public Set<Experience> createExperience(Long id, Experience experience){
        Candidate c = candidateRepo.findById(id).orElse(null);
        if (c == null || experience == null){
            return null;
        }
        c.addExperience(experience);
        candidateRepo.save(c);
        return c.getExperiences();
    }

    @Override
    public Set<ExperienceResponse> getCandidateExperience(Long id){
        Candidate c = candidateRepo.findById(id).orElse(null);
        if(c == null){
            return null;
        }
        Set<ExperienceResponse> expResSet = new HashSet<>();
        Set<Experience> es = c.getExperiences();
        for(Experience e:es){
            ExperienceResponse expRes = new ExperienceResponse();
            expRes.setName(e.getName());
            expRes.setDescription(e.getDescription());
            expRes.setEstablishment(e.getEstablishment());
            expRes.setStartDate(e.getStartDate());
            expRes.setEndDate(e.getEndDate());
            expRes.setType(e.getType().getName());
            expResSet.add(expRes);
        }

        return expResSet;
    }

    @Override
    public List<Experience> getAllExperiences(){
        return experienceRepo.findAll();
    }
}
