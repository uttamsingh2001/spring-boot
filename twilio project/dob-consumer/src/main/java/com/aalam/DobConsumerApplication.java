package com.aalam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class DobConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DobConsumerApplication.class, args);
	}

}
