package com.example.job_tailor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", unique = true)
    private Long categoryID;

    @NonNull
    @Column(name = "name")
    private String name;

    public Category(){}

}
