package com.EcartOneToMany.Ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EcartOneToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcartOneToManyApplication.class, args);
	}

}
