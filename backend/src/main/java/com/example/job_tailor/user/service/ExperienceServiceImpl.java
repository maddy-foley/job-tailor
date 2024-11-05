package com.example.job_tailor.user.service;

import com.example.job_tailor.user.model.Candidate;
import com.example.job_tailor.user.model.Experience;
import com.example.job_tailor.user.repo.CandidateRepo;
import com.example.job_tailor.user.repo.ExperienceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Experience createExperience(Long id, Experience experience){
        Candidate c = candidateRepo.findById(id).orElse(null);
        if (c == null || experience == null){
            return null;
        }
        experience.setCandidate(c);

        return experienceRepo.save(experience);
    }

    @Override
    public Set<Experience> getCandidateExperience(Long id){
        Candidate c = candidateRepo.findById(id).orElse(null);
        if(c == null){
            return null;
        }
        return c.getExperiences();
    }
}
