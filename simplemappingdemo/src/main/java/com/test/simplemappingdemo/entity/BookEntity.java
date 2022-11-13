package com.test.simplemappingdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private Set<AuthorEntity> author;


    public Set<AuthorEntity> getAuthor() {
        return author;
    }

    public void setAuthor(Set<AuthorEntity> author) {
        this.author = author;
    }
}
