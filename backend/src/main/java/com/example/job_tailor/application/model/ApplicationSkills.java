package com.example.job_tailor.application.model;

import com.example.job_tailor.common.model.Skill;
import com.example.job_tailor.common.model.Url;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "application_skills")
public class ApplicationSkills{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_skill_id", unique = true)
    private Long appSkillID;

    @ManyToMany
    @JoinTable(
        name = "skills",
        joinColumns = @JoinColumn(name = "application_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> applicationSkills;

}
