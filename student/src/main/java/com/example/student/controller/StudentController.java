package com.example.student.controller;

import com.example.student.entity.StudentEntity;
import com.example.student.model.StudentRequest;
import com.example.student.model.StudentResponse;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/students",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentRequest studentRequest)
    {
        StudentResponse studentResponse = studentService.createStudent(studentRequest);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/students",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentEntity>> getAllStudent()
    {
        return new ResponseEntity<>(studentService.getAllStudent(),HttpStatus.OK);

    }
    @GetMapping(value="/students/{studentId}",produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentRequest> getStudentById(@PathVariable Long studentId){
        StudentEntity studentEntity = studentService.getStudentById(studentId);
        return new ResponseEntity(studentEntity,HttpStatus.OK);


    }

    @PutMapping(value="/students/{studentId}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentRequest> updateStudent(@PathVariable Long studentId,@RequestBody StudentRequest studentRequest){
        studentService.updateStudent(studentId,studentRequest);
        return  ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping(path = "/employees/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
