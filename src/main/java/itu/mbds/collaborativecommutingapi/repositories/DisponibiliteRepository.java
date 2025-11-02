package itu.mbds.collaborativecommutingapi.repositories;

import itu.mbds.collaborativecommutingapi.entities.Disponibilite;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DisponibiliteRepository extends MongoRepository<Disponibilite, String> {
    List<Disponibilite> findByPositionNear(Point location, Distance distance);
    Optional<Disponibilite> findByConducteurId(String conducteurId);
    @Aggregation(pipeline = {
            "{ $geoNear: { near: ?0, distanceField: 'dist', maxDistance: ?1, spherical: true } }",
            "{ $lookup: { from: 'users', localField: 'conducteurId', foreignField: '_id', as: 'conducteur' } }",
            "{ $unwind: '$conducteur' }",
            "{ $match: { 'conducteur.type': 'CONDUCTEUR', 'statut': 'AVAILABLE' } }"
    })
    List<Disponibilite> findNearbyConducteursDisponibles(Point location, double maxDistance);

}
