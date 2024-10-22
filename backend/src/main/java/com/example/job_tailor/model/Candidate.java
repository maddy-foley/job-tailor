package com.example.job_tailor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import java.util.*;

@Getter
@Setter
@Entity
@Component
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "candidate_id")
    private Long CandidateID;

    @NonNull
    @Column(name = "first_name")
    private String FirstName;

//    @Column(name = "middle_name")
//    private String MiddleName;

    @NonNull
    @Column(name = "last_name")
    private String LastName;

//    @NonNull
//    @CreationTimestamp
    @Column(name = "date_created")
    private Date DateCreated;

//    @UpdateTimestamp
    @Column(name = "date_updated")
    private Date DateUpdated;

    @ManyToMany
    @JoinTable(
        name = "candidate_skills",
        joinColumns = @JoinColumn(name = "candidate_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    Set<Skill> skills = new HashSet<>();

    public Candidate(){

    }
}
