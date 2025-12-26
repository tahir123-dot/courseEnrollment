package com.example.workflow.Delegate;

import com.example.workflow.DTO.CoursesDTO;
import com.example.workflow.Service.CourseService;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.List;
import java.util.stream.Collectors;

@Named("courseLoadDelegate")
@RequiredArgsConstructor
public class CourseLoadDelegate implements JavaDelegate {

    private final CourseService courseService;

    @Override
    public void execute(DelegateExecution execution) {

        Object semesterObj = execution.getVariable("semester");
        if (semesterObj == null) {
            throw new RuntimeException("Semester variable is missing");
        }

        Long semester = Long.valueOf(semesterObj.toString());
        List<CoursesDTO> courses = courseService.getCoursesBySemester(semester);

        if (courses == null || courses.isEmpty()) {
            throw new RuntimeException("No courses found for semester: " + semester);
        }

        List<String> courseNames = courses.stream()
                .map(CoursesDTO::getCourseName)
                .collect(Collectors.toList());

        execution.setVariable("courseList", courseNames);
    }
}
