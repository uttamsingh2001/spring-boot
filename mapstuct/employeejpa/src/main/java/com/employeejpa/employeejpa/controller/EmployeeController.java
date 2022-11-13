package com.employeejpa.employeejpa.controller;

import com.employeejpa.employeejpa.entity.EmployeeEntity;
import com.employeejpa.employeejpa.model.EmployeeRequest;
import com.employeejpa.employeejpa.model.EmployeeResponse;
import com.employeejpa.employeejpa.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Log4j2
public class EmployeeController {


    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping(value = "/employees", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeRequest employeeRequest)
    {
        log.info("employee added successfully..........");
        EmployeeEntity employeeEntity= employeeService.createEmployee(employeeRequest);
        return new ResponseEntity<>( employeeEntity, HttpStatus.OK);
    }
   @GetMapping(value = "/employees",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeRequest>>  getAllEmployees()
   {
       log.info("all employee get successfully..... ");
       List<EmployeeRequest> employeeRequests=employeeService.getAllEmployees();
       return new ResponseEntity<>(employeeRequests,HttpStatus.OK);
   }
   @PutMapping(value = "/employees/{employeeId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable Long employeeId,@RequestBody EmployeeRequest employeeRequest)
   {
       log.info("employee update successfully..... ");
       EmployeeEntity employeeEntity=employeeService.updateEmployee(employeeId,employeeRequest);
       return new ResponseEntity<>(employeeEntity,HttpStatus.OK);
   }

   @DeleteMapping("/employees/{employeeId}")
   public void deleteEmployee(@PathVariable Long employeeId)
   {
       System.out.println("DeleteController called");
     employeeService.deleteEmployee(employeeId);
   }

   @GetMapping(path = "employees/{employeeId}")
   public ResponseEntity<EmployeeRequest> getEmployee(@PathVariable Long employeeId)
   {
      EmployeeRequest employeeRequest = employeeService.getEmployee(employeeId);
      return new ResponseEntity<>(employeeRequest,HttpStatus.OK);

   }




}
