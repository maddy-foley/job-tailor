package com.example.job_tailor.user.service;

import com.example.job_tailor.user.model.Experience;

import java.util.List;
import java.util.Set;

public interface ExperienceService {
    Set<Experience> createExperience(Long id, Experience experience);
    Set<Experience> getCandidateExperience(Long id);

    List<Experience> getAllExperiences();
}
