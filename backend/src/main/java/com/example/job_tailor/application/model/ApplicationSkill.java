package com.example.job_tailor.application.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "application_skills")
public class ApplicationSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_skill_id", unique = true)
    private Long applicationSkillID;


}
