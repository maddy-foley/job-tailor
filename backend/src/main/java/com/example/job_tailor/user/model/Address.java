package com.example.job_tailor.user.model;

import com.example.job_tailor.common.model.Url;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Component
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", unique = true)
    private Long addressId;

    @NonNull
    @Column(name = "email")
    private String email;

    @NonNull
    @Column(name = "phone")
    private String phone;

    @Column(name = "street_address")
    private String streetAddress;

    @NonNull
    @Column(name = "city")
    private String city;

    @NonNull
    @Column(name = "zip_code")
    private Integer zipCode;

    @NonNull
    @Column(name = "country")
    private String country;

    @NonNull
    @Column(name = "state")
    private String state;
//
//    @OneToOne
//    @JoinColumn(name = "candidate_id")
//    private Candidate candidate;

//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "url_id")
//    private Set<Url> urls;
    public Address(){}
    public Address(
            @NonNull String email,
            @NonNull String phone,
            @NonNull String city,
            @NonNull Integer zipCode,
            @NonNull String country,
            @NonNull String state,
            String streetAddress
            ){
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.state = state;
        this.streetAddress = streetAddress;
    }
}
