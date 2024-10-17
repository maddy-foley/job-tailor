package com.example.job_tailor.api.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "skill_id")
    private Long SkillID;

    @NonNull
    @Column(name = "name")
    private String Name;

    @Column(name = "years_of_experience")
    private Integer YOE;

    @Column(name = "ability")
    private Integer Ability; // self-rating out of 5

    @ManyToMany
    @JoinTable(
        name = "skill_categories",
        joinColumns = @JoinColumn(name = "skill_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    List<Category> categories;
}