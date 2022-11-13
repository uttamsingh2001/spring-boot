package com.aalam.employee.controller;

import com.aalam.employee.model.EmployeeRequest;

import com.aalam.employee.model.EmployeeResponse;
import com.aalam.employee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService ;

    public EmployeeController( EmployeeService employeeService ) {
        this.employeeService = employeeService;
    }
    @PostMapping("/employees")
    public ResponseEntity<EmployeeResponse>createEmployee(@RequestBody EmployeeRequest employeeRequest){
        return new ResponseEntity<>(employeeService.createEmployee(employeeRequest), HttpStatus.CREATED);
    }
}
