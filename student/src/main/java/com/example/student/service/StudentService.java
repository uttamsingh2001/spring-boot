package com.example.student.service;

import com.example.student.entity.StudentEntity;
import com.example.student.model.StudentRequest;
import com.example.student.model.StudentResponse;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public StudentResponse createStudent(StudentRequest studentRequest) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName(studentRequest.getFirstName());
        studentEntity.setLastName(studentRequest.getLastName());

        StudentResponse studentResponse = new StudentResponse();

        Random random = new Random();
        Long id = (long) (Math.random() * 20);
        studentEntity.setId((Long) id);

        studentResponse.setId(studentEntity.getId());
        studentRepository.save(studentEntity);
        return studentResponse;


    }

    public List<StudentEntity> getAllStudent() {
        return studentRepository.findAll();

    }

    public StudentEntity getStudentById(Long studentId) {
        return studentRepository.findById(studentId).get();
    }

    public StudentRequest updateStudent(Long studentId, StudentRequest studentRequest) {
    StudentEntity studentEntity = studentRepository.findById(studentId).get();
        if (Objects.nonNull(studentRequest.getFirstName()) && !"".equalsIgnoreCase(studentRequest.getFirstName()))
        {
            studentEntity.setFirstName(studentRequest.getFirstName());
        }
        if (Objects.nonNull(studentRequest.getFirstName()) && !"".equalsIgnoreCase(studentRequest.getFirstName()))
        {
            studentEntity.setFirstName(studentRequest.getFirstName());
        }
        studentRepository.save(studentEntity);
        return studentRequest;
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}

