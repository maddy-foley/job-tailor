package com.example.job_tailor.service;

import com.example.job_tailor.model.Skill;

import java.util.List;

public interface SkillService {
    Skill createSkill(Skill skill);
    List<Skill> getSkills();
}
