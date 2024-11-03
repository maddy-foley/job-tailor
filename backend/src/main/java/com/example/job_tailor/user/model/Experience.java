package com.example.job_tailor.user.model;

import com.example.job_tailor.common.model.Url;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name = "experiences")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id", unique = true)
    private Long ExperienceId;

    @NonNull
    @Column(name = "name")
    private String name;
    //nullable
    @Column(name = "establishment")
    private String establishment;

    @NonNull
    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    // don't cascade delete type
    @ManyToOne
    @JoinColumn(name="type_id")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

//   FIX
//    @OneToOne
//    @JoinColumn(name = "url_id", nullable = false)
//    private Url url;

    public Experience(){}
}
