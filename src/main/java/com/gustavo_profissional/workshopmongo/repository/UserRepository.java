package com.gustavo_profissional.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gustavo_profissional.workshopmongo.domain.User;

/* => Notas
 * MongoRepository já inclui as funções p/ Insert, Delete...
 * Parâmetros: <Tipo de Classe que Gerenciará, Tipo do Id (String)>
 *
 */

@Repository							
public interface UserRepository extends MongoRepository<User, String> {

}
