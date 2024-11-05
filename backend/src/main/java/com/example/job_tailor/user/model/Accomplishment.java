package com.example.job_tailor.user.model;

import com.example.job_tailor.user.model.Experience;
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
    private Long accomplishmentId;

    @NonNull
    @Column(name = "description")
    private String description;

    @Column(name = "experience_id")
    private Long experienceId;
    public Accomplishment(){};
}
