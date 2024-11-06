package com.example.job_tailor.common.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id", unique = true)
    private Long skillId;

    @NonNull
    @Column(name = "name", unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "skill_categories",
        joinColumns = @JoinColumn(name = "skill_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;

    public Skill(){}

    public void addCategory(Category category){
        if(category != null){
            if (categories == null){
                 this.categories = new HashSet<>();
            }
            this.categories.add(category);
        }
    }
}