package com.employeejpa.employeejpa.service;

import com.employeejpa.employeejpa.entity.EmployeeEntity;
import com.employeejpa.employeejpa.mapper.EmployeeMapper;
import com.employeejpa.employeejpa.model.EmployeeRequest;
import com.employeejpa.employeejpa.model.EmployeeResponse;
import com.employeejpa.employeejpa.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper)
    {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }


    public EmployeeEntity createEmployee(EmployeeRequest employeeRequest)
    {
        EmployeeEntity employeeEntity= employeeMapper.modeltoEntity(employeeRequest);
        employeeRepository.save(employeeEntity);

        return employeeEntity;
    }


    public List<EmployeeRequest> getAllEmployees() {

        List<EmployeeRequest> employeeRequests=employeeMapper.entitytoModel(employeeRepository.findAll());
        return employeeRequests;
    }

    public EmployeeEntity updateEmployee(Long employeeId,EmployeeRequest employeeRequest)
    {

      //EmployeeEntity employeeEntity=employeeRepository.save(employeeMapper.modeltoEntity(employeeRequest));
        EmployeeEntity employeeEntity=employeeMapper.modeltoEntity(employeeRequest);
        employeeEntity.setEmployeeId(employeeId);
        employeeRepository.save(employeeEntity);

        return employeeEntity;
    }

    public void deleteEmployee(Long employeeId)
    {
        EmployeeEntity employeeEntity = employeeRepository.getById(employeeId);

            employeeRepository.delete(employeeEntity);
            log.info("Employee successfully deleted with id "+employeeId);

    }


    public EmployeeRequest getEmployee(Long employeeId)
    {

        EmployeeRequest employeeRequest= new EmployeeRequest();
      Optional<EmployeeEntity> employeeEntity=  employeeRepository.findById(employeeId);

        if (employeeEntity.isPresent())
        {
            employeeRequest = employeeMapper.entitytoModel(employeeEntity.get());
        }
        else {
            log.error("Employee not found with id "+employeeId);
            employeeRequest=null;
        }
        return  employeeRequest;
    }
}
