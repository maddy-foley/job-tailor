package com.example.job_tailor.dto;

import com.example.job_tailor.model.Address;
import com.example.job_tailor.model.Candidate;
import lombok.Data;

@Data
public class CreateCandidateDto {
    private Candidate candidate;
    private Address address;
}