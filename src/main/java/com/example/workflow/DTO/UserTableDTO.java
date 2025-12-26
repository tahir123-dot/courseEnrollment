package com.example.workflow.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserTableDTO {

    private Long id;
    private String name;
    private Long regno;
    private String department;
    private String program;
    private Long semester;
    private Long phone;
    private List<GradesDTO> grades;

}
