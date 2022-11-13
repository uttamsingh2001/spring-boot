package com.manyTomany.manyTomany.services;

import com.manyTomany.manyTomany.entity.DepartmentEntity;
import com.manyTomany.manyTomany.mapper.DepartmentMapper;
import com.manyTomany.manyTomany.model.DepartmentRequest;
import com.manyTomany.manyTomany.model.DepartmentResponse;

import com.manyTomany.manyTomany.repository.DepartmentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    public DepartmentResponse createDept(DepartmentRequest departmentRequest) {
        log.info(departmentRequest.toString());
        DepartmentEntity departmentEntity=departmentMapper.modelToEntity(departmentRequest);
        log.info(departmentEntity.toString());
        departmentRepository.save(departmentEntity);
        log.info(departmentEntity.toString());
        DepartmentResponse departmentResponse= new DepartmentResponse();
        departmentResponse.setDeptId(departmentEntity.getId());
        return  departmentResponse;

    }

    public List<DepartmentRequest> getAllDepartment()
    {
        List<DepartmentEntity> departemtEntities = departmentRepository.findAll();

        return  departmentMapper.enitiesToModel(departemtEntities);
    }

    public DepartmentRequest getDepartment(Long deptId)
    {
        Optional<DepartmentEntity> departmentEntity=departmentRepository.findById(deptId);
        if(departmentEntity.isPresent())
        {
            return departmentMapper.entityToModel(departmentEntity.get());

        }
        else {
            log.info("No department present with id:"+deptId);
            return null;
        }
    }

    public String deleteDept(Long deptId)
    {
        Optional<DepartmentEntity> departmentEntity=departmentRepository.findById(deptId);
        if(departmentEntity.isPresent())
        {
            departmentRepository.delete(departmentEntity.get());
            return "Department deleted with id:"+deptId;

        }
        else {
            log.info("No department present with id:"+deptId);
            return "No department present with id:"+deptId ;
        }
    }

    public DepartmentRequest getDeptById(Long deptId) {
        DepartmentEntity departmentEntity = departmentRepository.findById(deptId).get();

        return departmentMapper.entityToModel(departmentEntity);
    }
}
