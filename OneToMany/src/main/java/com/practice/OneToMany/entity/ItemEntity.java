package com.practice.OneToMany.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "item_details")
public class ItemEntity {
    @Id
    @SequenceGenerator(name = "item_seq",initialValue = 1,sequenceName = "item_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
    private Long itemId;

    private String itemName;
    private Long quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cart;
}
