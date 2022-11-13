package com.employeeproject.employeeproject.controller;


import com.employeeproject.employeeproject.entity.EmployeeEntity;
import com.employeeproject.employeeproject.model.EmployeeRequest;
import com.employeeproject.employeeproject.model.EmployeeResponse;
import com.employeeproject.employeeproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
   private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeServices) {
        this.employeeService = employeeServices;
    }


//    public EmployeeController(EmployeeServices employeeServices) {
//        this.employeeServices = employeeServices;
//    }





    @PostMapping("/employees")
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest employeeRequest)
    {
        EmployeeResponse employeeResponse= employeeService.createEmployee(employeeRequest);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }


    @GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeEntity>> getAllEmployee() {
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }


    @GetMapping(value = "/employees/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeEntity> getEmployee(@PathVariable long employeeId){
        EmployeeEntity employeeEntity=employeeService.getEmployee(employeeId);
        return new ResponseEntity<>(employeeEntity,HttpStatus.OK);
    }


    @PutMapping(value = "/employees/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeRequest> updateEmployee(@PathVariable long employeeId,@RequestBody EmployeeRequest employeeRequest)
    {
        employeeService.updateEmployee(employeeId,employeeRequest);
        return ResponseEntity.ok().body(employeeRequest);
    }

    @DeleteMapping(value = "/employees/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteEmployee(@PathVariable long employeeId){
        this.employeeService.deleteEmployee(employeeId);
        return ResponseEntity.status(HttpStatus.OK).build();

    }


}
