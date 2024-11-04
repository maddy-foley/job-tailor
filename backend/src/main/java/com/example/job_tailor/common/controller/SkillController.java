package com.example.job_tailor.common.controller;

import com.example.job_tailor.common.model.Category;
import com.example.job_tailor.common.model.Skill;
import com.example.job_tailor.common.service.CategoryService;
import com.example.job_tailor.common.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan
@RestController
@RequestMapping(value = "api",produces = MediaType.APPLICATION_JSON_VALUE)
public class SkillController {
    @Autowired
    private SkillService skillService;

    @Autowired
    private CategoryService categoryService;



    public SkillController(SkillService skillService, CategoryService categoryService){
        this.skillService = skillService;
        this.categoryService = categoryService;
    }

    // FUTURE EDITS NEEDED
    @PostMapping("/public/skill/new")
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill){
        Skill createdSkill = skillService.createSkill(skill);
        if(createdSkill == null ){
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(skill, HttpStatus.OK);
        }
    }
    //make private

    @PutMapping("/public/skill/{id}")
    public ResponseEntity<Skill> updatedSkill(@PathVariable("id") Long id, @RequestBody Category category){
        Category c = categoryService.createCategory(category);
        Skill updatedSkill = skillService.updateSkill(id, c);
        if(updatedSkill == null){
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(updatedSkill, HttpStatus.OK);
    }

    @GetMapping("/public/skill/all")
    public ResponseEntity<List<Skill>> getSkills(){
        List<Skill> skills = skillService.getSkills();
        if(skills == null){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

}

