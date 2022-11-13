package com.aalam.dobconsumer;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Log4j2
public class DobConsumer {
    @Value("${spring.kafka.topic.name}")
    private String topicName ;

    @KafkaListener(topics = "${spring.kafka.topic.name}"
            , groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(ConsumerRecord<String, String> payload) {
        log.info("Topic: {}", topicName);
        log.info("key: {}", payload.key());
        log.info("Headers: {}", payload.headers());
        log.info("Partition: {}", payload.partition());
        log.info("Order: {}", payload.value());
        String value = payload.value();
        String[] s = value.split(",", 5);
        for (String s1 : s) {
            String to = s1.replace("email=", "");
            try {
               sendTextEmail(to);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

/*    public void sendMain(String to ) throws IOException {
        Email from = new Email("sameerali4120@gmail.com");
        Email receiver = new Email(to);
        Content content = new Content("text/plain","happy birth day");
        String  subject = "birthday mail";
        Mail mail = new Mail(from,subject,receiver,content);
        SendGrid sendGrid = new SendGrid("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");
        Request request = new Request();

        request.setMethod(Method.GET);
        request.setBody(mail.build());
        Response response = sendGrid.api(request);
        log.info("message", response.getBody());
    }*/



    public String sendTextEmail(String email) throws IOException {
        // the sender email should be the same as we used to Create a Single Sender Verification
        Email from = new Email("add the sender email");
        String subject = "The subject";
        Email to = new Email(email);
        Content content = new Content("text/plain", "This is a test email");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setBody(mail.build());
            Response response = sg.api(request);
            log.info(response.getBody());
            return response.getBody();
        } catch (IOException ex) {
            throw ex;
        }
    }



}
