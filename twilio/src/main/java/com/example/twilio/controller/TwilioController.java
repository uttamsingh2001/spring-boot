package com.example.twilio.controller;

import com.example.twilio.service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwilioController {

    @Value("${to}")
    private String to ;

    @Value("${body}")
    private String body ;

    @Value("${from}")
    private String from ;

    private final TwilioService twilioService ;

    @Autowired
    public TwilioController ( TwilioService twilioService ) {
        this.twilioService = twilioService;
    }
    @GetMapping("/send")
    public String send(){
        twilioService.sendSms(to,from,body);
        return "success";
    }


}