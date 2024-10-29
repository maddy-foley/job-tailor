package com.example.job_tailor.service;

import com.example.job_tailor.dto.CreateCandidateDto;
import com.example.job_tailor.dto.CreateCandidateResponse;
import com.example.job_tailor.model.Address;
import com.example.job_tailor.model.Candidate;

import java.util.Optional;

public interface CandidateService {
    CreateCandidateResponse createCandidate(CreateCandidateDto candidateInfo);
    Candidate getCandidate(Long candidateID);


}
