package com.example.job_tailor.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "applications")
public class ApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "application_id")
    private Long ApplicationID;

    @Column(name = "company")
    private String Company; // maybe turn to FK

    @Column(name = "name")
    private String Name;

    @Column(name = "date_created")
    private Date DateCreated;

    @Column(name = "date_updated")
    private Date DateUpdated;

    @Column(name = "job_post")
    private String JobPost;

    //skill connection, canididate connection, enum
}