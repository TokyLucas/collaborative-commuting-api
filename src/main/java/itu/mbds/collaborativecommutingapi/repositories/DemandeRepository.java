package itu.mbds.collaborativecommutingapi.repositories;

import itu.mbds.collaborativecommutingapi.entities.Demande;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface DemandeRepository extends MongoRepository<Demande, String> {
    List<Demande> findByEtudiantId(String etudiantId);
}
