package com.example.workflow.Service;

import com.example.workflow.DTO.GradesDTO;

public interface GradesImpl {

    GradesDTO addGrade(GradesDTO grade);
    GradesDTO updateGrade(Long id, GradesDTO grade);
    void deleteGrade(Long id);
}
