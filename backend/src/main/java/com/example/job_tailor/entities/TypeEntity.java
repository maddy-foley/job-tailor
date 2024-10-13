package com.example.job_tailor.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Types")
public class TypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long TypeID;
    private String Name;
    //experience connection
}
