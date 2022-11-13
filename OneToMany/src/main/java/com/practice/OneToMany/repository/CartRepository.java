package com.practice.OneToMany.repository;

import com.practice.OneToMany.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartEntity,Long> {
}
