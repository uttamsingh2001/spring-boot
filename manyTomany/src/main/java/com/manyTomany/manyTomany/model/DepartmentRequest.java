package com.manyTomany.manyTomany.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequest {
    private String departmentName;
    @JsonBackReference
    List<EmployeeRequest> employeeRequests;


}
