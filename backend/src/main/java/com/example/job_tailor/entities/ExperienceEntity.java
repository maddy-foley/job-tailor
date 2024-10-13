package com.example.job_tailor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
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
