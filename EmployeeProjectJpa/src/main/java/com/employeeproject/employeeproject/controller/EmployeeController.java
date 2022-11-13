package com.employeeproject.employeeproject.controller;


import com.employeeproject.employeeproject.entity.EmployeeEntity;
import com.employeeproject.employeeproject.model.EmployeeRequest;
import com.employeeproject.employeeproject.model.EmployeeResponse;
import com.employeeproject.employeeproject.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Log4j2
public class EmployeeController {

 public final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping(path="/employees", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest employeeRequest)
    {
        EmployeeResponse employeeResponse= employeeService.createEmployee(employeeRequest);
        return new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);
    }

    @GetMapping(path="/employees", consumes = APPLICATION_JSON_VALUE)
     public ResponseEntity<List<EmployeeEntity>> getALlEmployee()
     {

         log.info("success..............***********************************************");
         System.out.println("Controller");
         return new ResponseEntity<>(employeeService.getAllEmployee(),HttpStatus.OK);
     }

     @GetMapping(value = "/employees/{employeeId}",consumes = APPLICATION_JSON_VALUE)
     public ResponseEntity<Optional<EmployeeEntity>> getEmployee(@PathVariable Long employeeId)
     {

         Optional<EmployeeEntity> employeeEntity = this.employeeService.getEmployee(employeeId);

         if(employeeEntity==null)
         {

             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
         log.info("success");
         return ResponseEntity.of(Optional.of(employeeEntity));

     }

     @DeleteMapping(value = "/employees/{employeeId}")
     public ResponseEntity<Object> deleteEmployee(@PathVariable Long employeeId)
     {


             return ResponseEntity.status(HttpStatus.OK).build();

     }

     @PutMapping(value = "employees/{employeeId}", produces = APPLICATION_JSON_VALUE)
     public ResponseEntity<EmployeeRequest> updateEmployee(@PathVariable Long employeeId,@RequestBody EmployeeRequest employeeRequest) {
         employeeService.updateEmployee(employeeRequest, employeeId);
         return ResponseEntity.ok().body(employeeRequest);


   /* @PutMapping(value = "employees/{employeeId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable Long employeeId,@RequestBody EmployeeRequest employeeRequest)
    {
        employeeService.updateEmployee(employeeRequest,employeeId);
        return ResponseEntity<>(employeeRequest);
     }*/
     }
}
