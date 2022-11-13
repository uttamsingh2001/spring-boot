package com.crossasyst.mappingdemo.repository;

import com.crossasyst.mappingdemo.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Long> {
}
