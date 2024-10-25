package com.example.job_tailor.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "types")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id", unique = true)
    private Long TypeID;

    @NonNull
    @Column(name = "name")
    private String Name;

    public Type(){}
}
