package com.example.job_tailor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "accomplishments")
public class Accomplishment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accomplishment_id", unique = true)
    private Long accomplishmentID;

    @NonNull
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "experience_id", nullable = false)
    Experience experience;
    public Accomplishment(){};
}
