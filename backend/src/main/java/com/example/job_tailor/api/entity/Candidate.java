package com.example.job_tailor.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "candidates")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "candidate_id")
    private Long CandidateID;

    @NonNull
    @Column(name = "first_name")
    private String FirstName;

    @Column(name = "middle_name")
    private String MiddleName;

    @NonNull
    @Column(name = "last_name")
    private String LastName;

    @NonNull
    @Column(name = "date_created")
    private LocalDate DateCreated;

    @NonNull
    @Column(name = "date_updated")
    private LocalDate DateUpdated;

    @ManyToMany
    @JoinTable(
        name = "candidate_skills",
        joinColumns = @JoinColumn(name = "candidate_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    List<Skill> skills;
    public Candidate(){}
    public Candidate(@NonNull String firstName, String middleName, @NonNull String lastName){
        this.FirstName = firstName;
        // might need to change
        this.MiddleName = middleName;
        this.LastName = lastName;
        this.DateCreated = LocalDate.now();
        this.DateUpdated = LocalDate.now();
    }
}
