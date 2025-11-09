package itu.mbds.collaborativecommutingapi.repositories;

import itu.mbds.collaborativecommutingapi.entities.Demande;
import itu.mbds.collaborativecommutingapi.enums.Status;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface DemandeRepository extends MongoRepository<Demande, String> {
   List<Demande> findByEtudiantId(String etudiantId);
   Optional<Demande> findByEtudiantIdAndStatut(String etudiantId, Status statut);
   List<Demande> findByTrajetIdAndStatut(String trajetId, Status statut);
}

