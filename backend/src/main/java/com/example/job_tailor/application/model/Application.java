package com.example.job_tailor.application.model;

import com.example.job_tailor.common.model.Skill;
import com.example.job_tailor.user.model.Candidate;
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
    private Long applicationID;

    @NonNull
    @Column(name = "company")
    private String company; // maybe turn to FK

    @NonNull
    @Column(name = "name")
    private String name;

    @CreationTimestamp
    @Column(name = "date_created")
    private Date dateCreated;

    @UpdateTimestamp
    @Column(name = "date_updated")
    private Date dateUpdated;

    @Column(name = "job_post")
    private String jobPost;

    @Column(name = "candidate_id")
    private Long candidateId;

    @ManyToMany
    @JoinTable(
        name = "application_skills",
        joinColumns = @JoinColumn(name = "application_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills = new HashSet<>();

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "status")
    private EnumStatus status;

    public Application(){
    }

}