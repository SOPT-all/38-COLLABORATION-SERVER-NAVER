package com.sopt.collaboration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CollaborationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollaborationApplication.class, args);
	}

}
