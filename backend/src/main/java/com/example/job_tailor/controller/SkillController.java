package com.example.job_tailor.controller;

import com.example.job_tailor.model.Skill;
import com.example.job_tailor.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/skill",produces = MediaType.APPLICATION_JSON_VALUE)
public class SkillController {
    @Autowired
    private SkillService skillService;

    public SkillController(SkillService skillService){ this.skillService = skillService; }

    // FUTURE EDITS NEEDED
    @PostMapping("/new")
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill){
        Skill createdSkill = skillService.createSkill(skill);

        if(createdSkill == null ){
            return ResponseEntity.notFound().build();
        } else {
            System.out.println(skill);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(skill.getSkillID())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(createdSkill);
        }
    }

}

