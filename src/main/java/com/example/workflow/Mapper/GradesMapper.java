package com.example.workflow.Mapper;


import com.example.workflow.DTO.GradesDTO;
import com.example.workflow.Repository.CourseRepo;
import com.example.workflow.Repository.UserRepo;
import com.example.workflow.entity.Courses;
import com.example.workflow.entity.Grades;
import com.example.workflow.entity.UserTable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GradesMapper {


    private final CourseRepo courseRepo;
    private final UserRepo userRepo;
    // Entity to DTO
    public  GradesDTO getGradesDTO(Grades grades) {
        GradesDTO dto = new GradesDTO();
        dto.setId(grades.getId());
        dto.setCourse(grades.getCourses().getId());
        dto.setGrade(grades.getGrade());
        dto.setUser(grades.getUser().getId());
        return dto;
    }

    // DTO to Entity
    public Grades getGrades(GradesDTO dto) {

        Grades grades = new Grades();
        grades.setId(dto.getId());
        Courses course = courseRepo.findById(dto.getCourse()).orElseThrow(() -> new RuntimeException("Current Course not found"));
        UserTable userFind = userRepo.findById(dto.getUser()).orElseThrow(() -> new RuntimeException("User not found"));
        grades.setGrade(dto.getGrade());

        grades.setCourses(course);
        grades.setUser(userFind);

        return grades;
    }
}
