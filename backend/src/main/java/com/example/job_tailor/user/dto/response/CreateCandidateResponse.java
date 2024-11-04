package com.example.job_tailor.user.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Data
public class CreateCandidateResponse {
    @NonNull
    private String firstName;
}
