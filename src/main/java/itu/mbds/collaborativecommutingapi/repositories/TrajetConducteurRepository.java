package itu.mbds.collaborativecommutingapi.repositories;

import itu.mbds.collaborativecommutingapi.models.TrajetConducteur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetConducteurRepository extends MongoRepository<TrajetConducteur, String> {
}
