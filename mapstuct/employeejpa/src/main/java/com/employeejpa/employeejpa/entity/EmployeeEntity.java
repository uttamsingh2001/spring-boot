package com.employeejpa.employeejpa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    @Column(name ="first_name")
    private String firstName;
    @Column(name ="last_name")
    private String lastName;

}
