package com.example.workflow.Repository;

import com.example.workflow.entity.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserTable, Long> {
}
