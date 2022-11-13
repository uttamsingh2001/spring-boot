package com.employeeproject.employeeproject.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="employee")
public class EmployeeEntity {

    private long id;
    private String firstName;
    private String lastName;

}
