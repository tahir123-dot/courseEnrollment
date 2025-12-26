package com.example.workflow.Service.impl;

import com.example.workflow.DTO.UserTableDTO;
import com.example.workflow.Mapper.UserMapper;
import com.example.workflow.Repository.UserRepo;
import com.example.workflow.Service.UserImpl;
import com.example.workflow.entity.UserTable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements UserImpl {

    private final UserMapper userMapper;
    private final UserRepo userRepo;

    @Override
    public UserTableDTO addUser(UserTableDTO userTableDTO) {
        UserTable newUserTable = userMapper.toUserTable(userTableDTO);
        UserTable saveUser = userRepo.save(newUserTable);
        return userMapper.toUserTableDTO(saveUser);
    }

    @Override
    public List<UserTableDTO> getAllUsers() {
        List<UserTable> getUser = userRepo.findAll();
        return getUser.stream().map(userMapper::toUserTableDTO).collect(Collectors.toList());
    }

    @Override
    public UserTableDTO getUserById(Long id){
        UserTable getById = userRepo.findById(id).orElseThrow(() -> new RuntimeException("You can't get because user not found"));
        return userMapper.toUserTableDTO(getById);
    }

    @Override
    public UserTableDTO updateUser(Long id, UserTableDTO userTableDTO) {
        UserTable update = userRepo.findById(id).orElseThrow(() -> new RuntimeException("You can't get because user not found"));
        update.setName(userTableDTO.getName());
        update.setRegno(userTableDTO.getRegno());
        update.setDepartment(userTableDTO.getDepartment());
        update.setProgram(userTableDTO.getProgram());
        update.setSemester(userTableDTO.getSemester());
        update.setPhone(userTableDTO.getPhone());
        return userMapper.toUserTableDTO(userRepo.save(update));
    }

    @Override
    public void deleteUserById(Long id) {
        UserTable delete = userRepo.findById(id).orElseThrow(() -> new RuntimeException("You can't delete because user not found"));
        userRepo.delete(delete);
    }


}
