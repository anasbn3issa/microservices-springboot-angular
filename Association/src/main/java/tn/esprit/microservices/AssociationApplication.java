package tn.esprit.microservices;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
@EnableEurekaClient
@SpringBootApplication
public class AssociationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssociationApplication.class, args);
		System.out.println("XXXXXXX Testing XXXXXXX");
	}


}
