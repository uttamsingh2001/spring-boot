package com.EcartOneToMany.Ecart.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "item_id")
    private Long itemId;

    private Integer quantity;
    private Double price;


    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cart;

}
