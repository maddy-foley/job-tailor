package com.example.job_tailor.common.service;

import com.example.job_tailor.common.model.Skill;

import java.util.List;

public interface SkillService {
    List<Skill> createSkills(List<Skill> skills);
    List<Skill> getSkills();
}
