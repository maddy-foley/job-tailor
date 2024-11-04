package com.example.job_tailor.common.service;

import com.example.job_tailor.common.model.Category;
import com.example.job_tailor.common.model.Skill;

import java.util.List;

public interface SkillService {
    Skill createSkill(Skill skill);
    List<Skill> getSkills();

    Skill updateSkill(Long id, Category category);
}
