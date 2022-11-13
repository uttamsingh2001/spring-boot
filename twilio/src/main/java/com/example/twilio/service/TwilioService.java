package com.example.twilio.service;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class TwilioService {

    @Value("${auth}")
    private String auth ;

    @Value("${SID}")
    private String SID ;

    public void sendSms(String to,String from,String body){
        Twilio.init(SID,auth);

        PhoneNumber toPhoneNumber = new PhoneNumber(to);
        PhoneNumber fromPhoneNumber = new PhoneNumber(from);

        Message message =
                Message.creator(toPhoneNumber,fromPhoneNumber,body).create();
        log.info(message.getSid());
        log.info(message.getBody());
    }

}