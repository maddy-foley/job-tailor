package com.example.job_tailor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "application_id", columnDefinition = "serial")
    private Long ApplicationID;

    @NonNull
    @Column(name = "company")
    private String Company; // maybe turn to FK

    @NonNull
    @Column(name = "name")
    private String Name;

    @CreationTimestamp
    @Column(name = "date_created")
    private Date DateCreated;

    @UpdateTimestamp
    @Column(name = "date_updated")
    private Date DateUpdated;

    @Column(name = "job_post")
    private String JobPost;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    Candidate candidate;

    @ManyToMany
    @JoinTable(
        name = "application_skills",
        joinColumns = @JoinColumn(name = "application_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    List<Skill> skills = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;
}