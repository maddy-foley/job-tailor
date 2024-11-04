package com.example.job_tailor.common.service;

import com.example.job_tailor.common.model.Category;
import com.example.job_tailor.common.model.Skill;
import com.example.job_tailor.common.repo.CategoryRepo;
import com.example.job_tailor.common.repo.SkillRepo;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepo skillRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    SkillServiceImpl(SkillRepo skillRepo){ this.skillRepo = skillRepo;}


    @Override
    public Skill createSkill(@NonNull Skill skill) {
        Skill s = skillRepo.findByName(skill.getName());
        if (s == null){
            skillRepo.save(skill);
        }
        return skillRepo.findByName(skill.getName());
    }
    @Override
    public Skill updateSkill(Long id, Category category){
        Skill s = skillRepo.findBySkillId(id);

        //don't add if category already exists in skill
        if(s.getCategories().contains(category)){
            return s;
        } else{
            s.addCategory(category);
            return skillRepo.save(s);
        }
    }

    //delete later
    @Override
    public List<Skill> getSkills(){
        return skillRepo.findAll();
    }

}
