package com.practice.OneToMany.service;

import com.practice.OneToMany.entity.CartEntity;
import com.practice.OneToMany.entity.ItemEntity;
import com.practice.OneToMany.model.CartRequest;
import com.practice.OneToMany.model.CartResponse;
import com.practice.OneToMany.repository.CartRepository;
import com.practice.OneToMany.repository.ItemRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public CartService(CartRepository cartRepository, ItemRepository itemRepository) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
    }

    public CartResponse createCart(CartRequest cartRequest) {
/*
        CartEntity cartEntity = new CartEntity();
        cartEntity.setFirstName(cartRequest.getFirstName());
        cartEntity.setLastName(cartRequest.getLastName());


        ItemEntity itemEntity = new ItemEntity();

        itemEntity.setItemName(cartRequest.getItem().getItemName());
        itemEntity.setPrice(cartRequest.getItem().getPrice());
        itemEntity.setQuantity(cartRequest.getItem().getQuantity());

        itemEntity.setCart(cartEntity);
        cartRepository.save(cartEntity);
        itemRepository.save(itemEntity);

        CartResponse cartResponse = new CartResponse();
        cartResponse.setCartId(cartEntity.getCartId());
        return cartResponse;

   */

        CartEntity cartEntity = new CartEntity();
    cartEntity.setFirstName(cartRequest.getFirstName());
    cartEntity.setLastName(cartRequest.getLastName());

    ItemEntity entity = new ItemEntity();
    cartEntity.setItemEntities(
            cartRequest.getItems().stream().map(c->{
                entity.setItemName(c.getItemName());
                entity.setPrice(c.getPrice());
                entity.setQuantity(c.getQuantity());
                entity.setCart(cartEntity);
                return  c;
            }).collect(Collectors.toSet())
    );

        cartRepository.save(cartEntity);
        itemRepository.save(entity);


    log.info("item req "+cartRequest.getItems());
     CartResponse cartResponse=new CartResponse();
     cartResponse.setCartId(cartEntity.getCartId());
     return  cartResponse;
    }
}
