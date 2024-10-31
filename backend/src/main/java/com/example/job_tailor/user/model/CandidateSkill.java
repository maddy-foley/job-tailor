package com.example.job_tailor.user.model;

import com.example.job_tailor.common.model.Skill;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "candidate_skills")
public class CandidateSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_skill_id", unique = true)
    private Long candidateSkillID;

    @Column(name = "years_of_experience")
    private Integer yearsOfExperience;

    @Column(name = "ability")
    private Integer ability; // self-rating out of 5

}
