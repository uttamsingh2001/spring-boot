package com.crossasyst.mappingdemo.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "address_id")
    private Long addressId;

    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipcode;

    @OneToOne(mappedBy = "address")

    private PersonEntity person;
}
