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
    public List<Skill> createSkills(@NonNull List<Skill> skills) {
        for (Skill skill : skills){
            Skill s = new Skill();
            s.setName(skill.getName());
            skillRepo.save(s);
        }

        return skillRepo.findAll();
    };

    //delete later
    @Override
    public List<Skill> getSkills(){
        return skillRepo.findAll();
    }

}
