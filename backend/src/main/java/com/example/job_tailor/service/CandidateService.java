package com.example.job_tailor.service;

import com.example.job_tailor.model.Candidate;

import java.util.Optional;

public interface CandidateService {
    Candidate createCandidate(Candidate candidate);
    Candidate getCandidate(Long candidateID);
}
