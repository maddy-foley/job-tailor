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
    @Column(name = "accomplishment_id")
    private Long AccomplishmentID;

    @NonNull
    @Column(name = "description")
    private String Description;
    //experience connection
}
