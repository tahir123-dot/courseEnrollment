package com.example.workflow.Repository;

import com.example.workflow.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Courses, Long> {

    List<Courses> findBySemester(Long semester);

}
