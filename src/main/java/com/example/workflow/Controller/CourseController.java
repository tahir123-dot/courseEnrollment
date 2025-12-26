package com.example.workflow.Controller;

import com.example.workflow.DTO.CoursesDTO;
import com.example.workflow.Service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CoursesDTO> createCourse(@RequestBody CoursesDTO coursesDTO) {
            CoursesDTO savedCourse = courseService.addCourse(coursesDTO);
            return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CoursesDTO> getCourseById(@PathVariable("id") Long id) {
        CoursesDTO courseGet = courseService.getCourseById(id);
        return ResponseEntity.ok(courseGet);
    }

    @PutMapping("{id}")
    public ResponseEntity<CoursesDTO> updateCourse(@PathVariable("id") Long id, @RequestBody CoursesDTO courseDTO) {
        CoursesDTO update = courseService.updateCourse(id, courseDTO);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CoursesDTO> deleteCourse(@PathVariable("id") Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CoursesDTO>> getAllCourses() {
        List<CoursesDTO> allCourses = courseService.getAllCourses();
        return ResponseEntity.ok(allCourses);
    }

    @GetMapping("/semester/{semester}")
    public ResponseEntity<List<CoursesDTO>> getCoursesBySemester(@PathVariable("semester") Long semester) {
        List<CoursesDTO> allCourses = courseService.getCoursesBySemester(semester);
        return ResponseEntity.ok(allCourses);
    }
}
