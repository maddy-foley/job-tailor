package com.example.job_tailor.model;
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
    private Long urlID;

    @NonNull
    @Column(name = "url")
    private String url;

    public Url(){}
}
