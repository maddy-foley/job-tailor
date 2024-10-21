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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "url_id", columnDefinition = "serial")
    private Long UrlID;

    @NonNull
    @Column(name = "url")
    private String Url;
}
