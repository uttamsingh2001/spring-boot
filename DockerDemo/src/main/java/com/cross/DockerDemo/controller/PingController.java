package com.cross.DockerDemo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class PingController {

    @GetMapping(value = "/pings")
    public ResponseEntity<Void> myPing()
    {
        log.info("HttpStatus.OK");
        return new ResponseEntity<>(HttpStatus.OK);


    }

}
