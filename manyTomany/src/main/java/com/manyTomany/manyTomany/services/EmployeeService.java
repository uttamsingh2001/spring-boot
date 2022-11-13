package com.manyTomany.manyTomany.services;

import com.manyTomany.manyTomany.entity.DepartmentEntity;
import com.manyTomany.manyTomany.entity.EmployeeEntity;
import com.manyTomany.manyTomany.mapper.DepartmentMapper;
import com.manyTomany.manyTomany.mapper.EmployeeMapper;
import com.manyTomany.manyTomany.model.DepartmentRequest;
import com.manyTomany.manyTomany.model.EmployeeRequest;
import com.manyTomany.manyTomany.model.EmployeeResponse;
import com.manyTomany.manyTomany.repository.DepartmentRepository;
import com.manyTomany.manyTomany.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final DepartmentRepository departmentRepository;

    private final EmployeeMapper employeeMapper;
    private final DepartmentMapper departmentMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, EmployeeMapper employeeMapper, DepartmentMapper departmentMapper) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.employeeMapper = employeeMapper;
        this.departmentMapper = departmentMapper;
    }


    public List<EmployeeRequest> getEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        List<EmployeeRequest> employeeRequests = new ArrayList<>();

        employeeRequests = employeeMapper.entitiesToModel(employeeEntities);
        return employeeRequests;
    }


    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        EmployeeEntity employeeEntity=employeeRepository.save(employeeMapper.modelToEntity(employeeRequest));
        EmployeeResponse employeeResponse=new EmployeeResponse();
        employeeResponse.setId(employeeEntity.getId());
        return employeeResponse;


    }

    public EmployeeRequest getEmployeeById(Long employeeId) {
        EmployeeEntity getEmployee = employeeRepository.findById(employeeId).orElse(null);

       return employeeMapper.entityToModel(getEmployee);

    }

    public String deleteEmployee(Long employeeId) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);
        if(employeeEntity.isPresent())
        {
            employeeRepository.delete(employeeEntity.get());
            return "Employee deleted with Id: "+employeeId;
        }
        else
        {
            return "No employee present with id: "+employeeId;
        }
    }
    
    
//    public EmployeeRequest updateEmployee(Long empId,EmployeeRequest employeeRequest)
//
//    {
//        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(empId);
//        List<DepartmentEntity> departments = employeeEntity.get().getDepartments();
//        EmployeeEntity employeeEntity1 = employeeMapper.modelToEntity(employeeRequest);
//                 employeeEntity1.setId(empId);
//                 employeeRepository.save(employeeEntity1);
//        return employeeMapper.entityToModel(employeeEntity1);
//
//    }

    public EmployeeRequest addDepartmentToEmployee(Long empId, Long deptId)
    {
        EmployeeEntity employeeEntity = employeeRepository.findById(empId).get();
        DepartmentEntity departmentEntity = departmentRepository.findById(deptId).get();


        List<DepartmentEntity> departments = employeeEntity.getDepartments();
        departments.add(departmentEntity);
        employeeRepository.save(employeeEntity);
        return employeeMapper.entityToModel(employeeEntity);

    }

    public EmployeeRequest removeDepartmentFromEmployee(Long empId, Long deptId)
    {
        EmployeeEntity employeeEntity = employeeRepository.findById(empId).get();
        DepartmentEntity departmentEntity = departmentRepository.findById(deptId).get();


        List<DepartmentEntity> departments = employeeEntity.getDepartments();
        departments.remove(departmentEntity);
        employeeRepository.save(employeeEntity);
        return employeeMapper.entityToModel(employeeEntity);

    }
}
