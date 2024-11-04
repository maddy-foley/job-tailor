package com.example.job_tailor.user.service;

import com.example.job_tailor.user.dto.CreateCandidateDto;
import com.example.job_tailor.user.dto.response.CreateCandidateResponse;
import com.example.job_tailor.user.dto.response.GetCandidateByIdResponse;
import com.example.job_tailor.user.model.Candidate;

import java.util.List;

public interface CandidateService {
    CreateCandidateResponse createCandidate(CreateCandidateDto candidateInfo);
    GetCandidateByIdResponse getCandidate(Long candidateID);

    List<Candidate> getAllCandidates();

}
