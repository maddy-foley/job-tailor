package com.example.job_tailor.common.model;
import com.example.job_tailor.user.model.Candidate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "urls")
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "url_id", unique = true)
    private Long urlId;

    @NonNull
    @Column(name = "url")
    private String url;

//    @NonNull
//    @ManyToOne
//    @JoinColumn(name = "candidate_id", nullable = false)
//    Candidate candidate;

    public Url(){}
}
