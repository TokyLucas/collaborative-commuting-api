package itu.mbds.collaborativecommutingapi.repositories;

import itu.mbds.collaborativecommutingapi.entities.Demande;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface DemandeRepository extends MongoRepository<Demande, String> {
}
