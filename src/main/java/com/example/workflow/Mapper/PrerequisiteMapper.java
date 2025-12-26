package com.example.workflow.Mapper;

import com.example.workflow.DTO.PrerequisiteDTO;
import com.example.workflow.Repository.CourseRepo;
import com.example.workflow.entity.Courses;
import com.example.workflow.entity.Prerequisite;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PrerequisiteMapper {

    private final CourseRepo courseRepo;
    // Entity to DTO
    public  PrerequisiteDTO toDto(Prerequisite prerequisite) {
        PrerequisiteDTO dto = new PrerequisiteDTO();
        dto.setId(prerequisite.getId());
        dto.setCourse(prerequisite.getCourse().getId());
        dto.setPrerequisite(prerequisite.getPrerequisite().getId());
        return dto;
    }

    // DTO to Entity
    public Prerequisite toEntity(PrerequisiteDTO dto) {
        Prerequisite prerequisite = new Prerequisite();
        prerequisite.setId(dto.getId());
        Courses currentCourse = courseRepo.findById(dto.getCourse())
                .orElseThrow(() -> new RuntimeException("Current Course not found"));
        Courses prerequisiteCourse = courseRepo.findById(dto.getPrerequisite()).orElseThrow(() -> new RuntimeException("Prerequisite not found"));

        prerequisite.setCourse(currentCourse);
        prerequisite.setPrerequisite(prerequisiteCourse);
        return prerequisite;
    }
}
