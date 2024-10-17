package com.example.job_tailor.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name = "skills")
public class SkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "skill_id")
    private Long SkillID;

    @Column(name = "name")
    private String Name;

    @Column(name = "years_of_experience")
    private Integer YOE;

    @Column(name = "ability")
    private Integer Ability; // self-rating out of 5

    //put skills on candidate entity instead? Maybe seperate table?
    //candidate connection, category (many to many) connection, application connection
}