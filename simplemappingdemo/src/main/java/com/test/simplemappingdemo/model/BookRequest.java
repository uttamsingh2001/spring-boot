package com.test.simplemappingdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    private String name;
    private Set<AuthorRequest> author;

    public Set<AuthorRequest> getAuthor() {
        return author;
    }

    public void setAuthor(Set<AuthorRequest> author) {
        this.author = author;
    }
}
