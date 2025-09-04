package itu.mbds.collaborativecommutingapi.repositories;

import itu.mbds.collaborativecommutingapi.models.TrajetVoitureView;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface TrajetVoitureViewRepository  extends MongoRepository<TrajetVoitureView,String> {

    List<TrajetVoitureView> findByActif(Integer actif);
    //TrajetVoitureView findById(String id);

    List<TrajetVoitureView> findByIdConducteur(String idConducteur);

    // Ex: actifs + places > 0
    List<TrajetVoitureView> findByActifAndPlacesDisponiblesGreaterThan(Integer actif, Integer minPlaces);

    // Si ta vue convertit heureDepartEstimee en vrai Date, ceci marche :
    @Query("{ 'actif': 1, 'placesDisponibles': { $gt: 0 }, 'heureDepartEstimee': { $gt: ?0 } }")
    List<TrajetVoitureView> findUpcomingActive(Date now);
}
