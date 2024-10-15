package com.example.job_tailor.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "addresses")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long AddressID;

    @NonNull
    private String Email;
    @NonNull
    private String Phone;

    private String StreetAddress;

    @NonNull
    private String City;

    @NonNull
    private Integer ZipCode;

    @NonNull
    private String Country;

    @NonNull
    private String State;

    @OneToOne
    @JoinColumn(name = "candidate_id",nullable = false)
    private CandidateEntity candidate;

    //might need to change
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "url_id")
    private List<UrlEntity> urls = new ArrayList<>();
    AddressEntity(){}

}
