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

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

//    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
//    Set<CandidateSkill> CandidateSkills = new HashSet<>();

//    @OneToMany(mappedBy = "experience", cascade = CascadeType.ALL, orphanRemoval = true)
//    Set<Experience> experiences = new HashSet<>();

    public Candidate(){
    }
    public Candidate(@NonNull String firstName, @NonNull String lastName, Address address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

}
