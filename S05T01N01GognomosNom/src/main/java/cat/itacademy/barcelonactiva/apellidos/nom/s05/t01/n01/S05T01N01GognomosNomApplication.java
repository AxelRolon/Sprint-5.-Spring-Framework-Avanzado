package cat.itacademy.barcelonactiva.apellidos.nom.s05.t01.n01;

import org.springframework.boot.SpringApplication;

import org.modelmapper.ModelMapper;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S05T01N01GognomosNomApplication {

	public static void main(String[] args) {
		SpringApplication.run(S05T01N01GognomosNomApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper() {

	    return new ModelMapper();

	  }
}
