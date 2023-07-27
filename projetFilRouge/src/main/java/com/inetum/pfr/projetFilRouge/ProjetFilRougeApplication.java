package com.inetum.pfr.projetFilRouge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetFilRougeApplication {

	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "oracle,init");
		SpringApplication.run(ProjetFilRougeApplication.class, args);
		System.out.println("http://localhost:8080/projetFilRouge");
	}
}