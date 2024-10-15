package com.example.job_tailor.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "accomplishments")
public class AccomplishmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long AccomplishmentID;

    @NonNull
    private String Description;
    //experience connection
}
