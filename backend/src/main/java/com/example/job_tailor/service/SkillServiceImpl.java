package com.example.job_tailor.service;

import com.example.job_tailor.model.Skill;
import com.example.job_tailor.repository.SkillRepo;
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
    public List<Skill> createSkills(@NonNull List<Skill> skills) {
        for (Skill skill : skills){
            Skill s = new Skill();
            s.setName(skill.getName());
            s.setAbility(skill.getAbility());
            skillRepo.save(s);
        }

        return skillRepo.findAll();
    };

    @Override
    public List<Skill> getSkills(){
        return skillRepo.findAll();
    }
}
