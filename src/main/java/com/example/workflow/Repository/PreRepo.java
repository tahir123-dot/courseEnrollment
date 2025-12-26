package com.example.workflow.Repository;

import com.example.workflow.entity.Prerequisite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreRepo extends JpaRepository<Prerequisite, Long> {
}
