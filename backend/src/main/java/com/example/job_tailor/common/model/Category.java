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
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", unique = true)
    private Long categoryId;

    @NonNull
    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "categories")
    Set<Skill> skills = new HashSet<>();

    public Category(){}

}
