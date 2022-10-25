package com.esprit.microservice;

import java.util.Date;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.esprit.microservice.entities.Sterilization;
import com.esprit.microservice.entities.Veterinarian;
import com.esprit.microservice.repositories.SterilizationRepository;
import com.esprit.microservice.repositories.VeterinarianRepository;

@SpringBootApplication
@EnableEurekaClient
public class SterilizationMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SterilizationMsApplication.class, args);
	}
	
	
	@Bean
	ApplicationRunner init (VeterinarianRepository repository) {
		return args -> {
			repository.save(new Veterinarian("name", "address", "123456", "email")) ;


		};
	}

}
