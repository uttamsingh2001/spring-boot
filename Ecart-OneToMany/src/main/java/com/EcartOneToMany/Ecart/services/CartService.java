package com.EcartOneToMany.Ecart.services;

import com.EcartOneToMany.Ecart.entities.CartEntity;
import com.EcartOneToMany.Ecart.entities.ItemEntity;
import com.EcartOneToMany.Ecart.mapper.ItemMapper;
import com.EcartOneToMany.Ecart.model.ItemRequest;
import com.EcartOneToMany.Ecart.model.ItemResponse;
import com.EcartOneToMany.Ecart.repositories.CartRepository;
import com.EcartOneToMany.Ecart.mapper.CartMapper;
import com.EcartOneToMany.Ecart.model.CartRequest;
import com.EcartOneToMany.Ecart.model.CartResponse;
import com.EcartOneToMany.Ecart.repositories.ItemRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class CartService {


    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;
    private final CartMapper cartMapper;
    private final ItemMapper itemMapper;

    @Autowired
    public CartService(CartRepository cartRepository, ItemRepository itemRepository, CartMapper cartMapper, ItemMapper itemMapper) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
        this.cartMapper = cartMapper;
        this.itemMapper = itemMapper;
    }


    public CartResponse createCart(CartRequest cartRequest) {
        CartEntity cartEntity = cartMapper.modelToEntity(cartRequest);
        cartRepository.save(cartEntity);
        CartResponse cartResponse = new CartResponse();
        cartResponse.setCartId(cartEntity.getCartId());
        return cartResponse;
    }

    public List<CartRequest> getAllCarts() {
        List<CartEntity> cartEntities = cartRepository.findAll();

        return cartMapper.entitiesToModel(cartEntities);
    }

    public void deleteCart(Long id) {
        CartEntity cartEntity = cartRepository.findById(id).orElse(null);


        cartRepository.delete(cartEntity);
    }

    public CartRequest getCart(Long id) {
        CartEntity cartEntity = cartRepository.findById(id).orElse(null);
        log.info("Service is called");


        return cartMapper.entityToModel(cartEntity);
    }


    public CartRequest addItemToCart(Long cartId, Long itemId) {
        CartEntity cartEntity = cartRepository.findById(cartId).orElse(null);
        ItemEntity itemEntity = itemRepository.findById(itemId).orElse(null);
        List<ItemEntity> itemEntities = cartEntity.getItem();
        itemEntities.add(itemEntity);
        cartEntity.setCartId(cartId);
        cartRepository.save(cartEntity);

        return cartMapper.entityToModel(cartEntity);

    }

    public CartRequest removeItemFromCart(Long cartId, Long itemId) {
        CartEntity cartEntity = cartRepository.findById(cartId).orElse(null);
        List<ItemEntity> itemEntities = cartEntity.getItem();

        ItemEntity itemEntity = itemRepository.findById(itemId).get();
        itemEntities.remove(itemEntity);
        cartEntity.setCartId(cartId);
        cartRepository.save(cartEntity);

        return cartMapper.entityToModel(cartEntity);
    }


    public List<ItemRequest> getItemByCartId(Long cartId) {
        Optional<CartEntity> cartEntity = cartRepository.findById(cartId);

        List<ItemEntity> itemEntities= cartEntity.get().getItem();
        return  itemMapper.entitiesToModel(itemEntities);
    }

    public CartRequest updateCart(Long id,CartRequest cartRequest) {
        CartEntity cartEntity =cartRepository.findById(id).get();

        CartEntity cartEntity1=cartMapper.modelToEntity(cartRequest);
        List<ItemEntity> itemEntities = cartEntity.getItem();

        List<ItemEntity> itemEntities1 = cartEntity1.getItem();

        List<Long> list = new ArrayList<>();
        for(ItemEntity itemEntity:itemEntities)
        {

                list.add(itemEntity.getItemId());
                itemEntities.remove(itemEntity);


        }
        log.info("List of Id is : "+list);



        cartEntity1.setCartId(cartEntity.getCartId());

        for (ItemEntity itemEntity:itemEntities1)
        {
            list.stream().forEach((c) -> itemEntity.setItemId(c));
        }

        cartEntity1.setItem(itemEntities1);
        cartRepository.save(cartEntity1);

        return cartMapper.entityToModel(cartEntity1);

    }
}









