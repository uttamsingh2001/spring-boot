package com.EcartOneToMany.Ecart.controllers;

import com.EcartOneToMany.Ecart.model.CartRequest;
import com.EcartOneToMany.Ecart.model.CartResponse;
import com.EcartOneToMany.Ecart.model.ItemRequest;
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
@RequestMapping
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


    @PostMapping( value = "/carts/{cartsId}/items/{itemId}" , consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<CartRequest> addItemToCart(@PathVariable("cartsId") Long cartId,
                                                          @PathVariable Long itemId)
    {
        return   new ResponseEntity<>(cartService.addItemToCart(cartId,itemId),HttpStatus.OK);
    }

    @DeleteMapping( value = "/carts/{cartId}/items/{itemId}" , consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<CartRequest> removeItemFromCart(@PathVariable Long cartId,
                                                           @PathVariable Long itemId)
    {
         return   new ResponseEntity<>(cartService.removeItemFromCart(cartId,itemId),HttpStatus.OK);
    }


    @GetMapping(value = "carts/{cartId}/items",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemRequest>> getItemsByCartId(@PathVariable Long cartId)
    {
        log.info("inside controller:"+cartId);
        return new ResponseEntity<>(cartService.getItemByCartId(cartId),HttpStatus.ACCEPTED);
    }


    @PutMapping(value = "/carts/{cartId}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<CartRequest> updateCart(@PathVariable Long cartId, @RequestBody CartRequest cartRequest){
        return new ResponseEntity<>(cartService.updateCart(cartId,cartRequest),HttpStatus.OK);
    }
    }



