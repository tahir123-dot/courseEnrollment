package com.example.workflow.Service.impl;

import com.example.workflow.DTO.GradesDTO;
import com.example.workflow.Mapper.GradesMapper;
import com.example.workflow.Repository.GradesRepo;
import com.example.workflow.Service.GradesImpl;
import com.example.workflow.entity.Grades;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GradesService implements GradesImpl {

    private final GradesMapper gradesMapper;
    private final GradesRepo gradesRepo;

    @Override
    public GradesDTO addGrade(GradesDTO grade) {
        Grades newGrade = gradesMapper.getGrades(grade);
        Grades saveGrad = gradesRepo.save(newGrade);
        return gradesMapper.getGradesDTO(saveGrad);
    }

    @Override
    public GradesDTO updateGrade(Long id, GradesDTO grade) {
        Grades updateGrade = gradesRepo.findById(id).orElseThrow(() -> new RuntimeException("Grade not found with id:" + id));
        updateGrade.setGrade(grade.getGrade());
        Grades saveGrade = gradesRepo.save(updateGrade);
        return gradesMapper.getGradesDTO(saveGrade);
    }

    @Override
    public void deleteGrade(Long id) {

        Grades deleteGrade = gradesRepo.findById(id).orElseThrow(() -> new RuntimeException("Grade not found with id:" + id));
        gradesRepo.delete(deleteGrade);

    }
}
