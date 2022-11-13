package com.employeeproject.employeeproject.service;

import com.employeeproject.employeeproject.entity.EmployeeEntity;
import com.employeeproject.employeeproject.model.EmployeeRequest;
import com.employeeproject.employeeproject.model.EmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class EmployeeService {


    private List<EmployeeEntity> list;

    public EmployeeService()
    {
        list = new ArrayList<>();
        list.add(new EmployeeEntity(01,"Uttam","Singh"));
        list.add(new EmployeeEntity(1212, "CS", "Balram"));

    }


    public  EmployeeEntity getEmployee(long employeeId) {

        return list.stream().filter(e -> e.getId() == employeeId).findFirst().get();

    }


    //Create Employee
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        Random random=new Random();
        long id = (long) (Math.random() * 20);
        employeeEntity.setId((long)id);

        employeeEntity.setFirstName(employeeRequest.getFirstName());
        employeeEntity.setLastName(employeeRequest.getLastName());

        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employeeEntity.getId());


        list.add(employeeEntity);

        return employeeResponse;
    }


    //Get All Employee
    public List<EmployeeEntity> getAllEmployee() {
        return list;
    }





    public void updateEmployee(long employeeId, EmployeeRequest employeeRequest) {
        list.stream().map(e -> {
            if (e.getId() == employeeId) {
                e.setFirstName(employeeRequest.getFirstName());
                e.setLastName(employeeRequest.getLastName());
            }
            return e;

        }).collect(Collectors.toList());

    }

    public void deleteEmployee(long employeeId) {

        list.removeIf(e ->e.getId()==employeeId);

    }
}
