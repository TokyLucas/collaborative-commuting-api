package itu.mbds.collaborativecommutingapi.services.matching;

import itu.mbds.collaborativecommutingapi.entities.Demande;
import itu.mbds.collaborativecommutingapi.entities.Trajet;
import itu.mbds.collaborativecommutingapi.repositories.DemandeRepository;
import itu.mbds.collaborativecommutingapi.repositories.TrajetRepository;
import itu.mbds.collaborativecommutingapi.dtos.conducteur.ConducteurResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatchingService {

    private final DemandeRepository demandeRepository;
    private final TrajetRepository trajetRepository;

    public List<ConducteurResponseDTO> matchDemandes(String demandeId) {
        Demande demande = demandeRepository.findById(demandeId)
                .orElseThrow(() -> new RuntimeException("Demande non trouvée"));

        // Récupérer tous les trajets disponibles
        List<Trajet> trajets = trajetRepository.findAllAvailable(); // méthode à créer

        // Filtrer les trajets correspondant aux critères de la demande
        List<Trajet> trajetsMatch = trajets.stream()
                .filter(t -> t.getPlacesRestantes() >= demande.getNbDisponibilite()) // nb places demandées
                .filter(t -> distance(t.getDepartLatitude(), t.getDepartLongitude(),
                        demande.getDepartLatitude(), demande.getDepartLongitude()) <= 1.0)
                .filter(t -> distance(t.getArriveeLatitude(), t.getArriveeLongitude(),
                        demande.getArriveeLatitude(), demande.getArriveeLongitude()) <= 1.0)
                .filter(t -> t.getHeureDepart().isAfter(demande.getHeureDepartEstimee().minusMinutes(15)) &&
                        t.getHeureDepart().isBefore(demande.getHeureDepartEstimee().plusMinutes(15)))
                .collect(Collectors.toList());

        // Mapper en ConducteurResponseDTO
        return trajetsMatch.stream()
                .map(trajet -> mapper.toConducteurResponseDTO(trajet.getConducteur()))
                .collect(Collectors.toList());
    }

    // Calcul distance simple (Haversine ou approximative)
    private double distance(double lat1, double lon1, double lat2, double lon2) {

        return Math.sqrt(Math.pow(lat1 - lat2, 2) + Math.pow(lon1 - lon2, 2));
    }
}
