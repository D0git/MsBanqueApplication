package com.example.demo;

import entities.Compte;
import entities.TypeCompte;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repositories.CompteRepository;

import java.util.Date;

@SpringBootApplication
public class DemoApplication {

	//public static void main(String[] args) {
	//	SpringApplication.run(DemoApplication.class, args);
	//}
	CommandLineRunner start(CompteRepository compteRepository){
		return args ->{
			compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPARGNE))
		}
	}

}
