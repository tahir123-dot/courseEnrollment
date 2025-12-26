package com.example.workflow.Service;

import com.example.workflow.DTO.CoursesDTO;
import com.example.workflow.Repository.CourseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {

    CoursesDTO addCourse(CoursesDTO courseDTO);
    CoursesDTO getCourseById(Long id);
    CoursesDTO updateCourse(Long id, CoursesDTO courses);
    void deleteCourse(Long id);
    List<CoursesDTO> getAllCourses();
    List<CoursesDTO> getCoursesBySemester(Long semester);

}
