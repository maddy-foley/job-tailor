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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "accomplishment_id")
    private Long AccomplishmentID;

    @NonNull
    @Column(name = "description")
    private String Description;

    @ManyToOne
    @JoinColumn(name = "experience_id", nullable = false)
    Experience experience;
    public Accomplishment(){};
}
