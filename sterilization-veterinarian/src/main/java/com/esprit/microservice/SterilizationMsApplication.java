package com.esprit.microservice;

import java.util.Date;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.esprit.microservice.entities.Sterilization;
import com.esprit.microservice.repositories.SterilizationRepository;

@SpringBootApplication
@EnableEurekaClient
public class SterilizationMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SterilizationMsApplication.class, args);
	}
	
	
	@Bean
	ApplicationRunner init (SterilizationRepository repository) {
		return args -> {
			repository.save(new Sterilization("635707ef355d61f07785ce3c", new Date(), "remarks1", 11.2 , "635707ef355d61f07785ce3c")) ;


		};
	}

}
