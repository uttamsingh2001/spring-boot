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

import java.util.List;

@Log4j2
@Service
public class CartService {


    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;
    private  final CartMapper cartMapper;
    private final ItemMapper itemMapper;

    @Autowired
    public CartService(CartRepository cartRepository, ItemRepository itemRepository, CartMapper cartMapper, ItemMapper itemMapper) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
        this.cartMapper = cartMapper;
        this.itemMapper = itemMapper;
    }


    public CartResponse createCart(CartRequest cartRequest) {
        CartEntity cartEntity= cartMapper.modelToEntity(cartRequest);
        cartRepository.save(cartEntity);
        CartResponse cartResponse=new CartResponse();
        cartResponse.setCartId(cartEntity.getCartId());
        return  cartResponse;
    }

    public List<CartRequest> getAllCarts() {
        List<CartEntity> cartEntities = cartRepository.findAll();
       // itemRepository.deleteById(538l);
        return cartMapper.entitiesToModel(cartEntities);
    }

    public void deleteCart(Long id)
    {
        CartEntity cartEntity=cartRepository.findById(id).get();


        cartRepository.delete(cartEntity);
    }

    public CartRequest getCart(Long id) {
        CartEntity cartEntity= cartRepository.findById(id).get();
        log.info("Service is called");


        return cartMapper.entityToModel(cartEntity);
    }

    public CartRequest updateCart(Long id,CartRequest cartRequest) {
        CartEntity cartEntity =cartRepository.findById(id).get();

        List<ItemEntity> itemEntities = cartEntity.getItem();



        CartEntity cartEntity1=  cartMapper.modelToEntity(cartRequest);



        for(ItemEntity i: itemEntities)
        {
            log.info(i.getItemId());

        }
        cartEntity1.setCartId(cartEntity.getCartId());

        cartRepository.save(cartEntity1);

        return cartMapper.entityToModel(cartEntity1);

    }



    public ItemResponse addItemsToCart(ItemRequest itemRequest,Long cartId) {

        ItemEntity itemEntity=itemMapper.modelToEntity(itemRequest);
        log.info(itemEntity.toString());
        /*itemEntity.getCart().setCartId(cartId);
        itemRepository.save(itemEntity);
        ItemResponse itemResponse= new ItemResponse();
        itemResponse.setItemId(itemEntity.getItemId());*/
        return null;
    }

    public List<ItemRequest> getAllItem() {
        List<ItemEntity> itemEntities=itemRepository.findAll();
       return itemMapper.entitiesToModel(itemEntities);

    }

    public ItemRequest getItem(Long itemId) {
        ItemEntity itemEntity=itemRepository.findById(itemId).get();
        log.info("inside service:"+itemId);
        return itemMapper.entityToModel(itemEntity);

    }

    public void deleteItem(Long itemId) {
        ItemEntity itemEntity = itemRepository.findById(itemId).get();

        itemRepository.delete(itemEntity);

    }

public List<ItemRequest> getItemByCartId(Long cartId) {

        CartEntity cartEntity = cartRepository.findById(cartId).get();
        List<ItemEntity> itemEntities = cartEntity.getItem();

    List<ItemRequest> itemRequests = itemMapper.entitiesToModel(itemEntities);



    return itemRequests;

    }

  /*  public ItemRequest updateItem(Long id, ItemRequest itemRequest) {
        ItemEntity itemEntity= itemRepository.getById(id);
      //  System.out.println(itemEntity.toString());
        ItemEntity itemEntity1=itemMapper.modelToEntity(itemRequest);
        itemEntity1.setItemId(id);
      itemEntity1.getCart().setCartId(itemEntity.getCart().getCartId());
        itemRepository.save(itemEntity1);
        return itemRequest ;
*/

   }


