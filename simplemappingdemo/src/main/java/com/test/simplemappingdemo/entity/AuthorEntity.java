package com.test.simplemappingdemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  String firstname;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;
}
