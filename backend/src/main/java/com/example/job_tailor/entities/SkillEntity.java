package com.example.job_tailor.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@PersistenceContext
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