package com.example.workflow.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PrerequisiteDTO {
    private Long id;
    private Long course;
    private Long prerequisite;
}
