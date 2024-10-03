package com.gustavo_profissional.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo_profissional.workshopmongo.domain.User;
import com.gustavo_profissional.workshopmongo.repository.UserRepository;

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
}
