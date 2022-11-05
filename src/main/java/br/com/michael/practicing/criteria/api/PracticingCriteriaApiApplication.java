package br.com.michael.practicing.criteria.api;

import br.com.michael.practicing.criteria.api.personas.terapeuta.service.PopulaBancoDeDadosService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PracticingCriteriaApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(PracticingCriteriaApiApplication.class, args);

	}

	@Bean
	CommandLineRunner runner(PopulaBancoDeDadosService populaBancoDeDadosService) {

		return args -> {

			populaBancoDeDadosService.persisteDados();
		};

	}

}
