package com.employeeproject.employeeproject.model;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.employeeproject.employeeproject.entity.EmployeeEntity} entity
 */
@Data
public class EmployeeEntityRequest implements Serializable {
    private  String firstName;
    private  String lastName;
}