package com.aluracursos.desafioGutenberg;

import com.aluracursos.desafioGutenberg.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioGutenbergApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioGutenbergApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.muestraElMenu();
	}
}
