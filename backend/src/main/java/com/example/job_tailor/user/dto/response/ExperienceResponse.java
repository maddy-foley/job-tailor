package com.example.job_tailor.user.dto.response;

import com.example.job_tailor.user.model.Accomplishment;
import com.example.job_tailor.user.model.Type;
import com.okta.commons.lang.Locales;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Data
@Getter
@Setter
public class ExperienceResponse {
    String name;
    String establishment;
    String Description;
    LocalDate startDate;
    LocalDate endDate;
    String type;
    Set<Accomplishment> accomplishments;
}
