package com.example.workflow.Controller;


import com.example.workflow.DTO.UserTableDTO;
import com.example.workflow.Service.impl.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserTableDTO> saveUser(@RequestBody UserTableDTO userTableDTO) {
        UserTableDTO savedUser = userService.addUser(userTableDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserTableDTO>> getAllUsers() {
        List<UserTableDTO> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserTableDTO> getUserById(@PathVariable Long id) {
        UserTableDTO getUser = userService.getUserById(id);
        return new ResponseEntity<>(getUser, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserTableDTO> updateUser(@PathVariable Long id,@RequestBody UserTableDTO userTableDTO ) {
        UserTableDTO savedUser = userService.updateUser(id, userTableDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<UserTableDTO> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
