package com.example.job_tailor.user.model;

import com.example.job_tailor.common.model.Skill;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table( name = "candidate_skills")
public class CandidateSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_skill_id", unique = true)
    private Long candidateSkillId;

    @ManyToOne
    @MapsId("candidateId")
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToOne
    @MapsId("skillId")
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Column(name= "years_of_experience")
    private Integer yearsOfExperience;

    @Column(name = "ability")
    private Integer ability;

}
