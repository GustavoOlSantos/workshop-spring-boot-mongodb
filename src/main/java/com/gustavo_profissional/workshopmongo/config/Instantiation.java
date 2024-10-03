package com.gustavo_profissional.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gustavo_profissional.workshopmongo.domain.User;
import com.gustavo_profissional.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... arg0) throws Exception {
		
		//=> Deleta do MongoDB
		userRepository.deleteAll();	
		
		User miles = new User(null, "Miles Morales", "miles@gmail.com");
		User hobbie = new User(null, "Hobbie Brown", "hobbie@outlook.com");
		User gwen = new User(null, "Gwen Stacy", "gwen@gmail.com");
		
		//=> Salva a lista no MongoDB (Salvar apenas um elemento, utilize o Save())
		userRepository.saveAll(Arrays.asList(miles, hobbie, gwen));
	}

}
