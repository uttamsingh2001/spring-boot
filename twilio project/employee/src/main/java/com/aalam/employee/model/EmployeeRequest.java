package com.aalam.employee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    private String name;
    private String dob ;
    private String email ;
    private Double salary;
}
