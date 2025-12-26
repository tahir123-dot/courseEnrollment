package com.example.workflow.Mapper;

import com.example.workflow.DTO.UserTableDTO;
import com.example.workflow.entity.UserTable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserMapper {

    private final GradesMapper gradesMapper;

    // Entity to DTO
    public UserTableDTO toUserTableDTO(UserTable usertable) {
        UserTableDTO userTableDTO = new UserTableDTO();
        userTableDTO.setId(usertable.getId());
        userTableDTO.setName(usertable.getName());
        userTableDTO.setRegno(usertable.getRegno());
        userTableDTO.setDepartment(usertable.getDepartment());
        userTableDTO.setProgram(usertable.getProgram());
        userTableDTO.setSemester(usertable.getSemester());
        userTableDTO.setPhone(usertable.getPhone());
        userTableDTO.setGrades(usertable.getGrades().stream().map(gradesMapper::getGradesDTO).collect(Collectors.toList()));
        return userTableDTO;
    }

    // DTO to Entity
    public UserTable toUserTable(UserTableDTO userTableDTO) {
        UserTable userTable = new UserTable();
        userTable.setId(userTableDTO.getId());
        userTable.setName(userTableDTO.getName());
        userTable.setRegno(userTableDTO.getRegno());
        userTable.setDepartment(userTableDTO.getDepartment());
        userTable.setProgram(userTableDTO.getProgram());
        userTable.setSemester(userTableDTO.getSemester());
        userTable.setPhone(userTableDTO.getPhone());
        userTable.setGrades(userTableDTO.getGrades().stream().map(gradesMapper::getGrades).collect(Collectors.toList()));

        return userTable;
    }
}
