package com.example.job_tailor.common.controller;

import com.example.job_tailor.common.model.Skill;
import com.example.job_tailor.common.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api",produces = MediaType.APPLICATION_JSON_VALUE)
public class SkillController {
    @Autowired
    private SkillService skillService;



    public SkillController(SkillService skillService){ this.skillService = skillService; }

    // FUTURE EDITS NEEDED
    @PostMapping("public/skill/new")
    public ResponseEntity<List<Skill>> createSkill(@RequestBody List<Skill> skills){
        List<Skill> createdSkill = skillService.createSkills(skills);

        if(createdSkill == null ){
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(skills, HttpStatus.OK);
        }
    }
    //make private


    @GetMapping("public/skill/all")
    public ResponseEntity<List<Skill>> getSkills(){
        List<Skill> skills = skillService.getSkills();
        if(skills == null){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

}

