package com.gustavo_profissional.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gustavo_profissional.workshopmongo.domain.Post;
import com.gustavo_profissional.workshopmongo.domain.User;
import com.gustavo_profissional.workshopmongo.dto.AuthorDTO;
import com.gustavo_profissional.workshopmongo.repository.PostRepository;
import com.gustavo_profissional.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... arg0) throws Exception {
		
		SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
		sfd.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		//=> Deleta do MongoDB
		userRepository.deleteAll();	
		postRepository.deleteAll();	
		
		User miles = new User(null, "Miles Morales", "miles@gmail.com");
		User hobbie = new User(null, "Hobbie Brown", "hobbie@outlook.com");
		User gwen = new User(null, "Gwen Stacy", "gwen@gmail.com");
		
		//=> Salva a lista no MongoDB (Salvar apenas um elemento, utilize o Save())
		userRepository.saveAll(Arrays.asList(miles, hobbie, gwen));
		
		Post post1 = new Post(null, sfd.parse("21/03/2018"), "Partiu viagem", "Vou viajar para Rio de Janeiro. Abraços!", new AuthorDTO(miles));
		Post post2 = new Post(null, sfd.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(miles));
		
		//=> Salva a lista no MongoDB (Salvar apenas um elemento, utilize o Save())
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		miles.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(miles);
	}

}
