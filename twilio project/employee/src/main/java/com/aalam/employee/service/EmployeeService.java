package com.aalam.employee.service;

import com.aalam.employee.entity.EmployeeEntity;
import com.aalam.employee.model.EmployeeRequest;
import com.aalam.employee.model.EmployeeResponse;
import com.aalam.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository ;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employeeRequest.getName());
        employeeEntity.setDob(employeeRequest.getDob());
        employeeEntity.setSalary(employeeRequest.getSalary());
        employeeEntity.setEmail(employeeRequest.getEmail());
        employeeRepository.save(employeeEntity);
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setEmployeeId(employeeEntity.getEmployeeId());
        return employeeResponse;
    }

}
