package com.diversBrain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ProjetDiversBrainApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetDiversBrainApplication.class, args);
	}

}
