package com.mybank.registrations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients
public class RegistrationsApplication {
	@Bean
	public WebClient webClient() 
	  { 
		  return WebClient.builder().build();
	 
	 }
	
	 

	public static void main(String[] args) {
		SpringApplication.run(RegistrationsApplication.class, args);
		
		
	}

}
