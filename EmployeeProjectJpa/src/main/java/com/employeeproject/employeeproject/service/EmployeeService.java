package com.employeeproject.employeeproject.service;

import com.employeeproject.employeeproject.entity.EmployeeEntity;
import com.employeeproject.employeeproject.model.EmployeeRequest;
import com.employeeproject.employeeproject.model.EmployeeResponse;
import com.employeeproject.employeeproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class EmployeeService {


    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    //Create Employee
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {

        EmployeeEntity employeeEntity = new EmployeeEntity();



        employeeEntity.setFirstName(employeeRequest.getFirstName());
        employeeEntity.setLastName(employeeRequest.getLastName());
        employeeRepository.save(employeeEntity);

        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employeeEntity.getId());

        return employeeResponse;
    }


    public List<EmployeeEntity> getAllEmployee()
    {
        return employeeRepository.findAll();
    }

    public Optional<EmployeeEntity> getEmployee(Long employeeId)
    {
        return employeeRepository.findById(employeeId);
    }

    public void deleteEmployee(Long employeeId)
    {
        employeeRepository.deleteById(employeeId);
    }


    public EmployeeEntity updateEmployee(EmployeeRequest employeeRequest,Long employeeId) {

        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();

        employeeEntity.setId(employeeId);
        employeeEntity.setFirstName(employeeRequest.getFirstName());
        employeeEntity.setLastName(employeeRequest.getLastName());

        employeeRepository.save(employeeEntity);
        return employeeEntity;

    }

}

