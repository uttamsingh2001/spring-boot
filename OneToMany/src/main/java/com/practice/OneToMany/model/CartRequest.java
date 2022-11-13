package com.practice.OneToMany.model;

import com.practice.OneToMany.entity.ItemEntity;
import lombok.Data;

import java.util.Set;

@Data
public class CartRequest extends CartResponse {

    private String firstName;
    private String lastName;


    private Set<ItemEntity> items;
}
