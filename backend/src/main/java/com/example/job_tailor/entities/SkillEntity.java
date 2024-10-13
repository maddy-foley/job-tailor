package com.example.job_tailor.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name = "Skills")
public class SkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long SkillID;
    private String Name;
    private Integer YOE;
    private Integer Ability; // self-rating out of 5
    //candidate connection, category (many to many) connection, application connection
}