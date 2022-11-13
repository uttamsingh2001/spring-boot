package com.kafka.producer.controller;

import com.kafka.producer.service.TopicProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final TopicProducer topicProducer;

    public KafkaController(TopicProducer topicProducer) {
        this.topicProducer = topicProducer;
    }

    @GetMapping(value = "/send")
    public void send() {
        topicProducer.send("massage sent By Omkar ..............");
    }
}
