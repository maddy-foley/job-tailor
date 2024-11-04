package com.example.job_tailor.user.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AddCandidateSkillDto {
    private Integer yearsOfExperience;
    private Integer ability;
}
