package com.practice.OneToMany.controller;

import com.practice.OneToMany.model.CartRequest;
import com.practice.OneToMany.model.CartResponse;
import com.practice.OneToMany.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    private final CartService service;

    @Autowired
    public CartController(CartService service) {
        this.service = service;
    }

    @PostMapping("/posts")
    public ResponseEntity<CartResponse> createCart(@RequestBody CartRequest cartRequest) {
        CartResponse cartResponse = service.createCart(cartRequest);
        return new ResponseEntity<>(cartResponse, HttpStatus.OK);
    }

}
