package com.example.job_tailor.user.model;

import com.example.job_tailor.common.model.Skill;
import com.example.job_tailor.common.model.Url;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id", unique = true)
    private Long candidateId;

    @NonNull
    @Column(name = "first_name")
    private String firstName;

//    @Column(name = "middle_name")
//    private String middleName;

    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @NonNull
    @CreationTimestamp
    @Column(name = "date_created")
    private Date dateCreated;

    @UpdateTimestamp
    @Column(name = "date_updated")
    private Date dateUpdated;

    @Embedded
    private Address address;

    @OneToMany
    @JoinTable(
        name = "candidate_skills",
        joinColumns = @JoinColumn(name = "candidate_id"),
        inverseJoinColumns = @JoinColumn(name = "candidate_skill_id")
    )
    Set<CandidateSkill> CandidateSkills;

    public Candidate(){
    }
    public Candidate(@NonNull String firstName, @NonNull String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
