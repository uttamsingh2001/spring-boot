package com.aalam.controller;

import com.aalam.dobconsumer.DobConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

public class DobController {
    private final DobConsumer dobConsumer;

    @Autowired
    public DobController(DobConsumer dobConsumer) {
        this.dobConsumer = dobConsumer;
    }
}



