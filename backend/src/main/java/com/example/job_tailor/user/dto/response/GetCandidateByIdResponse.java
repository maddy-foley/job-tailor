package com.example.job_tailor.user.dto.response;

import com.example.job_tailor.user.model.Address;
import lombok.Data;

@Data
public class GetCandidateByIdResponse  {
    private String firstName;
    private String lastName;
    private Address address;
}
