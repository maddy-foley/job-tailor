package com.example.job_tailor.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CreateCandidateDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String city;
    private Integer zipCode;
    private String country;
    private String state;
    private String streetAddress;
    CreateCandidateDto(){}
}