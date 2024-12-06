package com.example.demo;

import com.example.demo.Repository.PersonajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	// Inyectamos el repositorio de personajes
	@Autowired
	private PersonajesRepository personajesRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	public void run(String... args) throws Exception {

		// Ahora imprimimos los personajes
		personajesRepository.imprimir();
	}
}
