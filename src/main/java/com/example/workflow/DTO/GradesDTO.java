package com.example.workflow.DTO;

import com.example.workflow.entity.GradeEnum.Grade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GradesDTO {

    private Long id;
    private Grade grade; // enum
    private Long user;
    private Long course;

}
