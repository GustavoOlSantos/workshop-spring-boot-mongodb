package com.gustavo_profissional.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo_profissional.workshopmongo.domain.User;
import com.gustavo_profissional.workshopmongo.repository.UserRepository;
import com.gustavo_profissional.workshopmongo.services.exception.ObjectNotFoundException;

/* => Notas
 * @AutoWired - Instancia Automaticamente o objeto (Injeção automática de dependências)
 * repo, que extende o mongoRepository, já possui uma plenitude de operações prontas
 */

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> opUser = repo.findById(id);
		
		if(!opUser.isPresent()) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		User user = opUser.get();	
		return user;
	}
}
