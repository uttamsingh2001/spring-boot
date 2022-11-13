package com.test.simplemappingdemo.repository;

import com.test.simplemappingdemo.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {
}
