package com.EcartOneToMany.Ecart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest
{
    private String firstName;
    private String lastName;

    private List<ItemRequest> item;
}
