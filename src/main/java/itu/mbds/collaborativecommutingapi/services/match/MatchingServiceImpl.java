package itu.mbds.collaborativecommutingapi.services.match;

import itu.mbds.collaborativecommutingapi.dtos.TrajetConducteurDTO;
import itu.mbds.collaborativecommutingapi.dtos.demande.DemandeResponseDTO;
import itu.mbds.collaborativecommutingapi.entities.Demande;
import itu.mbds.collaborativecommutingapi.mappers.TrajetConducteurMapper;
import itu.mbds.collaborativecommutingapi.mappers.DemandeMapper;
import itu.mbds.collaborativecommutingapi.models.TrajetConducteur;
import itu.mbds.collaborativecommutingapi.repositories.TrajetConducteurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatchingServiceImpl implements IMatchingService {
    private final TrajetConducteurRepository trajetConducteurRepository;

    public List<TrajetConducteurDTO> matchConducteurs(DemandeResponseDTO demandeDTO) {
        Demande demande = DemandeMapper.toEntity(demandeDTO);
        List<TrajetConducteur> conducteurs = trajetConducteurRepository.findAll();

        return conducteurs.stream()
                .filter(c -> c.getPlacesDisponibles() >= demande.getNbPlaces())
                .filter(c -> matchTrajet(demande, c))
                .map(TrajetConducteurMapper::toDto)
                .collect(Collectors.toList());
    }

    /*private boolean matchTrajet(Demande demande, TrajetConducteur conducteur) {
        // Check si points départ et arrivée EXACTS
        boolean exactMatch = demande.getPointDepart().equalsIgnoreCase(conducteur.getPointDepart())
                && demande.getPointArrivee().equalsIgnoreCase(conducteur.getPointArrivee());

        // Check si conducteur passe par le point départ et arrivée de l'étudiant
        boolean proximityMatch = distance(demande.getDepartLatitude(), demande.getDepartLongitude(),
                conducteur.getLatDepart(), conducteur.getLngDepart()) <= 3.0
                && distance(demande.getArriveeLatitude(), demande.getArriveeLongitude(),
                conducteur.getLatArrivee(), conducteur.getLngArrivee()) <= 3.0;

        if (!exactMatch && !proximityMatch) return false;

        // Vérification horaires
        if (demande.getPointArrivee().equalsIgnoreCase(conducteur.getPointArrivee())) {
            // même destination → heures d'arrivée estimées doivent correspondre
            return demande.getHeureArriveeEstimee().equals(conducteur.getHeureDepartEstimee());
        } else {
            // destination différente → heure de passage du conducteur au point de l'étudiant doit correspondre
            return demande.getHeureArriveeEstimee().equals(conducteur.getHeureDepartEstimee());
        }
    }

    // Haversine pour distance GPS
    private double distance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // rayon Terre en km
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }*/

    private boolean matchTrajet(Demande demande, TrajetConducteur conducteur) {
        return demande.getPointDepart().equalsIgnoreCase(conducteur.getPointDepart())
                && demande.getPointArrivee().equalsIgnoreCase(conducteur.getPointArrivee());
    }
}
