package com.example.job_tailor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class JobTailorApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobTailorApplication.class, args);
    }
}

