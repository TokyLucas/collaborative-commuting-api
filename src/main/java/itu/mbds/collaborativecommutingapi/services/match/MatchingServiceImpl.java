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

    private boolean matchTrajet(Demande demande, TrajetConducteur conducteur) {
        // Vérifie si les points de départ et d'arrivée sont exactement les mêmes
        boolean exactMatch = demande.getPointDepart().equalsIgnoreCase(conducteur.getPointDepart())
                && demande.getPointArrivee().equalsIgnoreCase(conducteur.getPointArrivee());

        // Vérifie si le conducteur passe à proximité (moins de 3 km du point de départ et d’arrivée)
        boolean proximityMatch = distance(demande.getDepartLatitude(), demande.getDepartLongitude(),
                conducteur.getLatDepart(), conducteur.getLngDepart()) <= 3.0
                && distance(demande.getArriveeLatitude(), demande.getArriveeLongitude(),
                conducteur.getLatArrivee(), conducteur.getLngArrivee()) <= 3.0;
        return exactMatch || proximityMatch;
    }
    private double distance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371;
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
