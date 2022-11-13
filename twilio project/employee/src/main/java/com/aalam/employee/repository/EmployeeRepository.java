package com.aalam.employee.repository;

import com.aalam.employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}