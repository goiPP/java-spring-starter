package com.starter.javaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JavaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringApplication.class, args);
	}

}
