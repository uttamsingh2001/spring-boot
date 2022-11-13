package com.EcartOneToMany.Ecart.mapper;

import com.EcartOneToMany.Ecart.entities.CartEntity;
import com.EcartOneToMany.Ecart.model.CartRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper
{
    CartRequest entityToModel (CartEntity cartEntity);
    CartEntity modelToEntity (CartRequest cartRequest);
    List<CartRequest> entitiesToModel (List<CartEntity> cartEntity);
}
