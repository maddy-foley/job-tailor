package com.example.job_tailor.application.model;

import com.example.job_tailor.common.model.Skill;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "application_skills")
public class ApplicationSkills extends Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_skill_id", unique = true)
    private Long appSkillID;
}
