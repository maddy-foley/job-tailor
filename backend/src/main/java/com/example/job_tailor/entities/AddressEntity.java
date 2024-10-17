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
    @Column(name = "address_id")
    private Long AddressID;

    @NonNull
    @Column(name = "email")
    private String Email;

    @NonNull
    @Column(name = "phone")
    private String Phone;

    @Column(name = "street_address")
    private String StreetAddress;

    @NonNull
    @Column(name = "city")
    private String City;

    @NonNull
    @Column(name = "zip_code")
    private Integer ZipCode;

    @NonNull
    @Column(name = "country")
    private String Country;

    @NonNull
    @Column(name = "state")
    private String State;

    @OneToOne
    @JoinColumn(name = "candidate_id",nullable = false)
    private CandidateEntity candidate;

    //might need to change
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "url_id")
    private List<UrlEntity> urls = new ArrayList<>();
    public AddressEntity() {
    }
}
