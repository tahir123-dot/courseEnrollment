package com.example.workflow.Delegate;


import com.example.workflow.DTO.UserTableDTO;
import com.example.workflow.Service.impl.UserService;
import jakarta.inject.Named;
import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


@Named
@AllArgsConstructor
public class UserDelegate implements JavaDelegate {

    private final UserService userService;


    @Override
    public void execute(DelegateExecution execution) throws Exception {

        Long userId = Long.parseLong(execution.getVariable("userId").toString());

        UserTableDTO getUserInfo = userService.getUserById(userId);

        execution.setVariable("name", getUserInfo.getName());
        execution.setVariable("regno", getUserInfo.getRegno());
        execution.setVariable("department", getUserInfo.getDepartment());
        execution.setVariable("program", getUserInfo.getProgram());
        execution.setVariable("semester", getUserInfo.getSemester());
        execution.setVariable("Phone", getUserInfo.getPhone());


    }
}
