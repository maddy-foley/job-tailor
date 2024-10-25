package com.example.job_tailor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "experiences")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id", unique = true)
    private Long ExperienceID;

    @NonNull
    @Column(name = "name")
    private String Name;
    //nullable
    @Column(name = "establishment")
    private String Establishment;

    @NonNull
    @Column(name = "description")
    private String Description;

    @Column(name = "start_date")
    private LocalDate StartDate;

    @Column(name = "end_date")
    private LocalDate EndDate;

    // don't cascade delete type
    @ManyToOne
    @JoinColumn(name="type_id", nullable = false)
    Type type;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    Candidate candidate;

    @OneToOne
    @JoinColumn(name = "url_id", nullable = false)
    private Url url;

    public Experience(){}
}
