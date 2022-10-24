package tn.esprit.ms.local;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class LocalApplication {
	public static void main(String[] args) {
		SpringApplication.run(LocalApplication.class, args);
	}

}
