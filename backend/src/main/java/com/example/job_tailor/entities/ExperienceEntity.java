package com.example.job_tailor.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "experiences")
public class ExperienceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "experience_id")
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
    TypeEntity type;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="accomplishment_id", nullable = false)
    List<AccomplishmentEntity> accomplishments;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    CandidateEntity candidate;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="url_id", nullable = false)
    List<UrlEntity> urls;
}
