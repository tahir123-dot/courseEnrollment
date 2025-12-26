package com.example.workflow.Repository;

import com.example.workflow.entity.Grades;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradesRepo extends JpaRepository<Grades, Long> {
}
