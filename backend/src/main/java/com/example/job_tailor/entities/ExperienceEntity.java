package com.example.job_tailor.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
@PersistenceContext
@Table(name = "Experiences")
public class ExperienceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ExperienceID;
    private String Name;
    private String Establishment;
    private String Description;
    private Date StartDate;
    private Date EndDate;
    //accomplishment, type connection, candidate, url
}
