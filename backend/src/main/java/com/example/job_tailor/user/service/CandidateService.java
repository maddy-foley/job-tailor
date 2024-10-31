package com.example.job_tailor.user.service;

import com.example.job_tailor.user.dto.CreateCandidateDto;
import com.example.job_tailor.user.dto.CreateCandidateResponse;
import com.example.job_tailor.user.model.Candidate;
import com.example.job_tailor.common.model.Skill;

import java.util.List;

public interface CandidateService {
    CreateCandidateResponse createCandidate(CreateCandidateDto candidateInfo);
    Candidate getCandidate(Long candidateID);
    String addCandidateSkills(Long candidateId,List<Skill> skills);

}
