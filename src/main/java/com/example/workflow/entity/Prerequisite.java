package com.example.workflow.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "prereq")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prerequisite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Current course
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Courses course;

    // Prerequisite course
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prereq_id", nullable = false)
    private Courses prerequisite;
}
