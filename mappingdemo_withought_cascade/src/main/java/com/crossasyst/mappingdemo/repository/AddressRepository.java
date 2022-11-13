package com.crossasyst.mappingdemo.repository;

import com.crossasyst.mappingdemo.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,Long> {

}
