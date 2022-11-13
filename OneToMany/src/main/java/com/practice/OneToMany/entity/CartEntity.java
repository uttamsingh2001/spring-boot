package com.practice.OneToMany.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_details")
public class CartEntity {
    @Id
    @SequenceGenerator(name = "cart_seq",initialValue = 1,sequenceName = "cart_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_seq")
    private Long cartId;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "cart")
//    @JoinColumn(name = "cartId")
    private Set<ItemEntity> itemEntities;
//    ItemEntity items;


}
