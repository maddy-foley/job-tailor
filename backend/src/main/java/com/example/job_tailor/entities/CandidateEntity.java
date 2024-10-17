package com.example.job_tailor.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "candidates")
public class CandidateEntity {
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
    public CandidateEntity(){}
    public CandidateEntity(@NonNull String firstName, String middleName, @NonNull String lastName){
        this.FirstName = firstName;
        // might need to change
        this.MiddleName = middleName;
        this.LastName = lastName;
        this.DateCreated = LocalDate.now();
        this.DateUpdated = LocalDate.now();
    }
}
