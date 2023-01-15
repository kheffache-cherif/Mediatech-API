package org.cherif.mediatheque;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MediathequeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediathequeApplication.class, args);
	}

	@Bean  // creation d'un bean et sera enregister dans bean factory
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
