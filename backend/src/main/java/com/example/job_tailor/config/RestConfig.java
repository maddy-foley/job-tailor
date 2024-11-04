package com.example.job_tailor.config;

import com.example.job_tailor.application.model.ApplicationSkill;
import com.example.job_tailor.common.model.Skill;
import com.example.job_tailor.user.model.Address;
import com.example.job_tailor.user.model.Candidate;
import com.example.job_tailor.user.model.CandidateSkill;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Candidate.class);
        config.exposeIdsFor(Address.class);
        config.exposeIdsFor(Skill.class);
        config.exposeIdsFor(ApplicationSkill.class);
        config.exposeIdsFor(CandidateSkill.class);
    }
}
