package com.example.job_tailor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", unique = true)
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
    private Candidate candidate;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "url_id")
    private Set<Url> urls = new HashSet<>();
    public Address(){}
}
