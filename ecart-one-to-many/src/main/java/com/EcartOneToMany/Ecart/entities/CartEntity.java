package com.EcartOneToMany.Ecart.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "cart")
@AllArgsConstructor
@NoArgsConstructor
public class CartEntity
{
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)


    private Long cartId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private List<ItemEntity> item;
}
