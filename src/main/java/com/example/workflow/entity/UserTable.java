package com.example.workflow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users_table")
public class UserTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "regno", nullable = false, unique = true)
    private Long regno;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "program")
    private String program;

    @Column(name = "semester", nullable = false)
    private Long semester;


    @Column(name = "phone", nullable = false, unique = true)
    private Long phone;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Grades> grades = new ArrayList<>();
}
