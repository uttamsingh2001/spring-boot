package com.EcartOneToMany.Ecart.controllers;

import com.EcartOneToMany.Ecart.model.CartRequest;
import com.EcartOneToMany.Ecart.model.CartResponse;
import com.EcartOneToMany.Ecart.model.ItemRequest;
import com.EcartOneToMany.Ecart.model.ItemResponse;
import lombok.extern.log4j.Log4j2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.EcartOneToMany.Ecart.services.CartService;

import java.util.List;

@Log4j2
@RestController
public class CartController {

    private final CartService cartService;


    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;

    }


    @PostMapping( value = "/carts" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartResponse> createCart(@RequestBody CartRequest cartRequest)
    {
        CartResponse cartResponse= cartService.createCart(cartRequest);
        return new ResponseEntity<>(cartResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/carts",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CartRequest>> getAllCarts()
    {
        log.info("controller is callled....");
        return new ResponseEntity<>(cartService.getAllCarts(),HttpStatus.OK);
    }


    @DeleteMapping(value = "/carts/{id}")
    public String deleteCart(@PathVariable Long id)
    {
        log.info("controller is callled....");
        cartService.deleteCart(id);
        return "Cart is deleted with id: "+id;
    }


    @GetMapping(value = "/carts/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartRequest> getCart(@PathVariable Long id)
    {
        log.info("controller is callled....");
        return new ResponseEntity<>(cartService.getCart(id),HttpStatus.OK);
    }

    @PutMapping(value = "/carts/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartRequest> updateCart(@PathVariable Long id,@RequestBody CartRequest cartRequest)
    {
        return new ResponseEntity<>(cartService.updateCart(id,cartRequest),HttpStatus.ACCEPTED);
    }




    @PostMapping(value="/carts/{cartId}/items",produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<ItemResponse> addItems(@RequestBody  ItemRequest itemRequest,@PathVariable Long cartId){
        return new ResponseEntity<>(cartService.addItemsToCart(itemRequest,cartId),HttpStatus.CREATED);
    }




    @GetMapping(value = "carts/items",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemRequest>> getAllItem()
    {
      List<ItemRequest> itemRequests= cartService.getAllItem();
      return new ResponseEntity<>(itemRequests,HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "carts/items/{itemId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemRequest> getItem(@PathVariable Long itemId)
    {
        log.info("inside controller:"+itemId);
        return new ResponseEntity<>(cartService.getItem(itemId),HttpStatus.ACCEPTED);
    }


    @GetMapping(value = "carts/{cartId}/items",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemRequest>> getItemsByCartId(@PathVariable Long cartId)
    {
        log.info("inside controller:"+cartId);
        return new ResponseEntity<>(cartService.getItemByCartId(cartId),HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/carts/items/{itemId}")
    public String deleteItem(@PathVariable Long itemId)
    {

       cartService.deleteItem(itemId);
       return "item with id:"+itemId+" is successfully deleted..";

    }

/*
    @PutMapping(value = "/carts/items/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemRequest> updateCart(@PathVariable Long id,@RequestBody ItemRequest itemRequest)
    {
        return new ResponseEntity<>(cartService.updateItem(id,itemRequest),HttpStatus.ACCEPTED);
    }*/
    }



