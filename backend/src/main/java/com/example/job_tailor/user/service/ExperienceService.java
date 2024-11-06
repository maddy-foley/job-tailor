package com.example.job_tailor.user.service;

import com.example.job_tailor.user.dto.response.ExperienceResponse;
import com.example.job_tailor.user.model.Experience;

import java.util.List;
import java.util.Set;

public interface ExperienceService {
    ExperienceResponse createExperience(Long id, Experience experience);
    Set<ExperienceResponse> getCandidateExperience(Long id);

    List<Experience> getAllExperiences();
}
