package com.example.workflow.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CoursesDTO {

    private Long id;
    private String courseCode;
    private String courseName;
    private String credits;
    private Long semester;
    private Set<PrerequisiteDTO> prerequisites;
}
