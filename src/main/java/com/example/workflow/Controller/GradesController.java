package com.example.workflow.Controller;

import com.example.workflow.DTO.GradesDTO;
import com.example.workflow.Service.impl.GradesService;
import com.example.workflow.entity.Grades;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/grade")
@AllArgsConstructor
public class GradesController {

    private final GradesService gradesService;

    @PostMapping
    public ResponseEntity<GradesDTO> addGrade(@RequestBody GradesDTO gradesDTO) {
        GradesDTO savedGrade = gradesService.addGrade(gradesDTO);
        return new ResponseEntity<>(savedGrade, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<GradesDTO> updateGrade(@PathVariable("id") Long id, @RequestBody GradesDTO gradesDTO) {
        GradesDTO savedGrade = gradesService.updateGrade(id, gradesDTO);
        return new ResponseEntity<>(savedGrade, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GradesDTO> deleteGrade(@PathVariable("id") Long id) {
        gradesService.deleteGrade(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
