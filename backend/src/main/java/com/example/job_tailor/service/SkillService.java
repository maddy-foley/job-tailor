package com.example.job_tailor.service;

import com.example.job_tailor.model.Skill;

import java.util.List;

public interface SkillService {
    List<Skill> createSkills(List<Skill> skills);
    List<Skill> getSkills();
}
