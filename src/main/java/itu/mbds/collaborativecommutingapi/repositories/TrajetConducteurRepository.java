package itu.mbds.collaborativecommutingapi.repositories;

import itu.mbds.collaborativecommutingapi.models.TrajetConducteur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrajetConducteurRepository extends MongoRepository<TrajetConducteur, String> {
    List<TrajetConducteur> findByIdConducteur(String conducteurId);
    List<TrajetConducteur> findByStatutIgnoreCase(String statut);

}
