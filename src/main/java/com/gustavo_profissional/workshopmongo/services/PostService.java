package com.gustavo_profissional.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo_profissional.workshopmongo.domain.Post;
import com.gustavo_profissional.workshopmongo.repository.PostRepository;
import com.gustavo_profissional.workshopmongo.services.exception.ObjectNotFoundException;

/* => Notas
 * @AutoWired - Instancia Automaticamente o objeto (Injeção automática de dependências)
 * repo, que extende o mongoRepository, já possui uma plenitude de operações prontas
 */

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Optional<Post> opPost = repo.findById(id);
		
		if(!opPost.isPresent()) {
			throw new ObjectNotFoundException("Post não encontrado");
		}
		
		Post foundPost = opPost.get();	
		return foundPost;
	}
	
	public List<Post> findByTitle(String text){
		//return repo.findByTitleContaining(text);
		return repo.searchTitle(text);
	}

}
