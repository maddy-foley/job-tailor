package com.example.job_tailor.common.service;

import com.example.job_tailor.common.model.Skill;
import com.example.job_tailor.common.repo.SkillRepo;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepo skillRepo;

    SkillServiceImpl(SkillRepo skillRepo){ this.skillRepo = skillRepo;}


    @Override
    public Skill createSkill(@NonNull Skill skill) {
        Skill s = skillRepo.findByName(skill.getName());
        if (s == null){
            skillRepo.save(skill);
        }
        return skillRepo.findByName(skill.getName());
    }



    //delete later
    @Override
    public List<Skill> getSkills(){
        return skillRepo.findAll();
    }

}
