package com.test.simplemappingdemo.repository;

import com.test.simplemappingdemo.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {
}
