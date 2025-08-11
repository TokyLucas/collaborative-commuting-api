package itu.mbds.collaborativecommutingapi.repositories;

import itu.mbds.collaborativecommutingapi.entities.Disponibilite;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DisponibiliteRepository extends MongoRepository<Disponibilite, String> {
    List<Disponibilite> findByPositionNear(Point location, Distance distance);
    Optional<Disponibilite> findByConducteurId(String conducteurId);
}
