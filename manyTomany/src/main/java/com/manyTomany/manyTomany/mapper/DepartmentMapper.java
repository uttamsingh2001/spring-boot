package com.manyTomany.manyTomany.mapper;

import com.manyTomany.manyTomany.entity.DepartmentEntity;
import com.manyTomany.manyTomany.model.DepartmentRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentEntity modelToEntity(DepartmentRequest departmentRequest);
    DepartmentRequest entityToModel(DepartmentEntity departmentEntity);
    List<DepartmentRequest> enitiesToModel(List<DepartmentEntity> departmentEntities);
}
