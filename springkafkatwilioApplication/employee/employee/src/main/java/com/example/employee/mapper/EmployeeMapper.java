package com.example.employee.mapper;

import com.example.employee.entity.EmployeeEnitity;
import com.example.employee.model.EmployeeRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface EmployeeMapper {

    EmployeeEnitity modelToEnitity(EmployeeRequest employeeRequest);
    EmployeeRequest enitityToModel(EmployeeEnitity employeeEnitity);

}
