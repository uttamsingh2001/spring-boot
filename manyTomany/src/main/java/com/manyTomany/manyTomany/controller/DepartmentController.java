package com.manyTomany.manyTomany.controller;

import com.manyTomany.manyTomany.model.DepartmentRequest;
import com.manyTomany.manyTomany.model.DepartmentResponse;
import com.manyTomany.manyTomany.services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping(value = "departments",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentResponse> createDepartment(DepartmentRequest departmentRequest)
    {
        return  new ResponseEntity<>(departmentService.createDept(departmentRequest), HttpStatus.CREATED);
    }

    @GetMapping("/departments")
    public ResponseEntity<List<DepartmentRequest>> getAllDepartments()
    {
        return new ResponseEntity<>(departmentService.getAllDepartment(),HttpStatus.OK);
    }

    @GetMapping("/departments/{deptId}")
    public ResponseEntity<DepartmentRequest> getAllDepartments(@PathVariable Long deptId)
    {
        return new ResponseEntity<>(departmentService.getDeptById(deptId),HttpStatus.OK);
    }

}
