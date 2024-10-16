package com.example.job_tailor.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@PersistenceContext
@Entity
@Table(name = "Addresses")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long AddressID;
    private String Email;
    private String Phone;
    private String StreetAddress;
    //city, zipcode, country, state, candidate, url
}
