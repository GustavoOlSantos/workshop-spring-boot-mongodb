package com.gustavo_profissional.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.gustavo_profissional.workshopmongo.domain.Post;

/* => Notas
 * MongoRepository já inclui as funções p/ Insert, Delete...
 * Parâmetros: <Tipo de Classe que Gerenciará, Tipo do Id (String)>
 *
 */

@Repository							
public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> findByTitleContaining(String text);
	
	@Query("{'title' : { $regex: ?0, $options: 'i'} }")
	List<Post> searchTitle(String text);
}
