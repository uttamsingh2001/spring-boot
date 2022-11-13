package com.EcartOneToMany.Ecart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest extends ItemResponse
{

    private String itemName;
    private Integer quantity;
    private Double price;
/*
    private CartRequest cartRequest;
*/



}
