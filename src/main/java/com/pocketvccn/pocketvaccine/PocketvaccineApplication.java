package com.pocketvccn.pocketvaccine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class PocketvaccineApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocketvaccineApplication.class, args);
	}

}
