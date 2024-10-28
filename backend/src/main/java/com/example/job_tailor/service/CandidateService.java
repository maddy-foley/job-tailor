package com.example.job_tailor.service;

import com.example.job_tailor.dto.CreateCandidateDto;
import com.example.job_tailor.model.Candidate;

import java.util.Optional;

public interface CandidateService {
    Candidate createCandidate(CreateCandidateDto userInfo);
    Candidate getCandidate(Long candidateID);


}
