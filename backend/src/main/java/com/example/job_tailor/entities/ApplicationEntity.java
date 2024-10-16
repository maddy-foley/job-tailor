package com.example.job_tailor.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@Entity
@PersistenceContext
@Table(name = "Applications")
public class ApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ApplicationID;
    private String Company; // maybe turn to FK
    private String Name;
    private Date DateCreated;
    private Date DateUpdated;
    private String JobPost;

    //skill connection, canididate connection, enum
}