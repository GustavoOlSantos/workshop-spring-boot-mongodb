package com.gustavo_profissional.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo_profissional.workshopmongo.domain.User;
import com.gustavo_profissional.workshopmongo.dto.UserDTO;
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
			throw new ObjectNotFoundException("Usuário não encontrado");
		}
		
		User user = opUser.get();	
		return user;
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);			//=> Verifica se o Id existe p/ deletar
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj); //=> Copia o obj para o newObj
		return repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
