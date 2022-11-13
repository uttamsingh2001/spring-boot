package com.crossasyst.mappingdemo.model;


import lombok.Data;

@Data
public class PersonRequest {

    private String firstName;
    private String lastName;
    private AddressRequest address;
}
