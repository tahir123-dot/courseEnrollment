package com.example.workflow.Service.impl;

import com.example.workflow.DTO.CoursesDTO;
import com.example.workflow.Mapper.CourseMapper;
import com.example.workflow.Mapper.PrerequisiteMapper;
import com.example.workflow.Repository.CourseRepo;
import com.example.workflow.Service.CourseService;
import com.example.workflow.entity.Courses;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final CourseMapper courseMapper;
    private final PrerequisiteMapper prerequisiteMapper;

    @Override
    public CoursesDTO addCourse(CoursesDTO courseDTO) {
        Courses newCourse = courseMapper.maptoCourse(courseDTO);
        Courses savedCourse = courseRepo.save(newCourse);
        return courseMapper.maptoCourseDto(savedCourse);
    }

    @Override
    public CoursesDTO getCourseById(Long id) {
        Courses course = courseRepo.findById(id).orElseThrow(() -> new RuntimeException("Course not found with id:" + id));
        return courseMapper.maptoCourseDto(course);

    }

    @Override
    public CoursesDTO updateCourse(Long id, CoursesDTO courses) {

        Courses course = courseRepo.findById(id).orElseThrow(() -> new RuntimeException("You can't edit because course not found"));

        if(courses.getCourseCode() != null){
            course.setCourseName(courses.getCourseName());
        }
        if(courses.getCourseName() != null){
            course.setCourseCode(courses.getCourseCode());
        }
       if(courses.getCredits() != null){
           course.setCredits(courses.getCredits());
       }
       if(courses.getSemester() != null){
           course.setSemester(courses.getSemester());
       }
       if(courses.getPrerequisites() != null){
           course.setPrerequisites(courses.getPrerequisites().stream().map(prerequisiteMapper::toEntity).collect(Collectors.toSet()));
       }

        Courses updateCourse = courseRepo.save(course);
        return courseMapper.maptoCourseDto(updateCourse);
    }

    @Override
    public void deleteCourse(Long id) {

        Courses course = courseRepo.findById(id).orElseThrow(() -> new RuntimeException("Course not found with id:" + id));
        courseRepo.delete(course);
    }



    @Override
    public List<CoursesDTO> getAllCourses() {
        List<Courses> courses = courseRepo.findAll();

        return courses.stream()
                .map(courseMapper::maptoCourseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CoursesDTO> getCoursesBySemester(Long semester) {

        List<Courses> coursesBySemester = courseRepo.findBySemester(semester);

        return coursesBySemester.stream()
                .map(courseMapper::maptoCourseDto)
                .collect(Collectors.toList());
    }


}
