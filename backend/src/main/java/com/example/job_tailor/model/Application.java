package com.example.job_tailor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id",unique = true)
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
    Candidate Candidate;

    @ManyToMany
    @JoinTable(
        name = "application_skills",
        joinColumns = @JoinColumn(name = "application_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    Set<Skill> Skills = new HashSet<>();

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private EnumStatus Status;

    public Application(){
    }

}