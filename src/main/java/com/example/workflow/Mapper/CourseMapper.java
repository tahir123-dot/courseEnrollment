package com.example.workflow.Mapper;

import com.example.workflow.DTO.CoursesDTO;
import com.example.workflow.entity.Courses;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CourseMapper {

    private final PrerequisiteMapper prerequisiteMapper;

    public CoursesDTO maptoCourseDto(Courses course) {

        CoursesDTO dto = new CoursesDTO();
        dto.setId(course.getId());
        dto.setCourseCode(course.getCourseCode());
        dto.setCourseName(course.getCourseName());
        dto.setCredits(course.getCredits());
        dto.setSemester(course.getSemester());
        dto.setPrerequisites(
                course.getPrerequisites()
                        .stream()
                        .map(prerequisiteMapper::toDto)
                        .collect(Collectors.toSet())
        );

        return dto;
    }

    public Courses maptoCourse(CoursesDTO dto) {
        Courses course = new Courses();
        course.setId(dto.getId());
        course.setCourseCode(dto.getCourseCode());
        course.setCourseName(dto.getCourseName());
        course.setCredits(dto.getCredits());
        course.setSemester(dto.getSemester());
        return course;
    }
}
