package com.codeLearner.Ziganya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ZiganyaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZiganyaApplication.class, args);
	}

}
