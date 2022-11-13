package com.employeejpa.employeejpa.mapper;

import com.employeejpa.employeejpa.entity.EmployeeEntity;
import com.employeejpa.employeejpa.model.EmployeeRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    public EmployeeEntity modeltoEntity(EmployeeRequest employeeRequest);

    public EmployeeRequest entitytoModel(EmployeeEntity employeeEntity);

    public List<EmployeeRequest> entitytoModel(List<EmployeeEntity> employeeEntity);


}
