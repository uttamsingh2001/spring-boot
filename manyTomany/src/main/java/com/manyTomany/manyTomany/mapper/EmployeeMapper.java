package com.manyTomany.manyTomany.mapper;

import com.manyTomany.manyTomany.entity.EmployeeEntity;
import com.manyTomany.manyTomany.model.EmployeeRequest;
import com.manyTomany.manyTomany.model.EmployeeResponse;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeEntity modelToEntity( EmployeeRequest employeeRequest);

    EmployeeRequest entityToModel (EmployeeEntity employeeEntity);

    List<EmployeeRequest> entitiesToModel (List<EmployeeEntity> employeeEntity);

}
