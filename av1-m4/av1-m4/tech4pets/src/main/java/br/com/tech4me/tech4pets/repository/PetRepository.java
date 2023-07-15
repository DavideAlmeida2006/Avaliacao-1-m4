package br.com.tech4me.tech4pets.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.tech4me.tech4pets.model.Pet;

public interface PetRepository extends MongoRepository<Pet, String> {
}
