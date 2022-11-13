package com.manyTomany.manyTomany.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.manyTomany.manyTomany.entity.DepartmentEntity;
import com.manyTomany.manyTomany.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest  {
    private String firstName;

    private String lastName;

    @JsonManagedReference
    private List<DepartmentRequest> departments;
}
