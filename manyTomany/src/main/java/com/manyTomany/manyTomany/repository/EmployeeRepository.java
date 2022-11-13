package com.manyTomany.manyTomany.repository;

import com.manyTomany.manyTomany.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository< EmployeeEntity, Long > {
}
