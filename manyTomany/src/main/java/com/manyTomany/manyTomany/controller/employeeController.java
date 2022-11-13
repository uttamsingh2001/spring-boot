package com.manyTomany.manyTomany.controller;

import com.manyTomany.manyTomany.model.EmployeeRequest;
import com.manyTomany.manyTomany.model.EmployeeResponse;
import com.manyTomany.manyTomany.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@Controller
public class employeeController {

    private final EmployeeService employeeService;

    @Autowired
    public employeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employees" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeRequest>> getEmployees()
    {
        List<EmployeeRequest> employeeRequests = employeeService.getEmployees();
        return new ResponseEntity<>(employeeRequests , HttpStatus.OK);
    }

    @PostMapping(value = "/employees" , produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest employeeRequest)
    {
        EmployeeResponse employeeResponse= employeeService.createEmployee(employeeRequest);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/employees/{employeeId}" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeRequest> getEmployees(@PathVariable Long employeeId)
    {
        EmployeeRequest employeeRequest = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeRequest , HttpStatus.OK);
    }

    @DeleteMapping("employees/employeeId")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId)
    {
        return new ResponseEntity<>(employeeService.deleteEmployee(employeeId),HttpStatus.OK);
    }


    @PutMapping(value = "/employees/{empId}/departments/{deptId}")
    public ResponseEntity<EmployeeRequest> addDeptToEmp(@PathVariable Long empId,@PathVariable Long deptId)
    {
        return new ResponseEntity<>(employeeService.addDepartmentToEmployee(empId, deptId),HttpStatus.OK);
    }

    @DeleteMapping(value = "/employees/{empId}/departments/{deptId}")
    public ResponseEntity<EmployeeRequest> removeDeptFromEmp(@PathVariable Long empId,@PathVariable Long deptId)
    {
        return new ResponseEntity<>(employeeService.removeDepartmentFromEmployee(empId, deptId),HttpStatus.OK);
    }

}
