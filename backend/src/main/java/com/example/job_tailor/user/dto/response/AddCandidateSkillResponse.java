package com.example.job_tailor.user.dto.response;

import com.example.job_tailor.common.model.Category;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Data
public class AddCandidateSkillResponse {
    @NonNull
    private String name;
    @NonNull
    private Integer yearsOfExperience;
    @NonNull
    private Integer ability;
    @NonNull
    private Set<Category> categories;
}
