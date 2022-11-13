package com.manyTomany.manyTomany.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NegativeOrZero;
import java.util.List;

@Entity
@Data
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "dept_name")
    private String departmentName;

    @ManyToMany(mappedBy = "departments")

    private List<EmployeeEntity> employees;
}
