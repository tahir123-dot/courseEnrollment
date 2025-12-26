package com.example.workflow.Service;

import com.example.workflow.DTO.UserTableDTO;

import java.util.List;

public interface UserImpl {

    UserTableDTO addUser(UserTableDTO userTableDTO);
    List<UserTableDTO> getAllUsers();
    UserTableDTO getUserById(Long id);
    UserTableDTO updateUser(Long id,UserTableDTO userTableDTO);
    void deleteUserById(Long id);
}
