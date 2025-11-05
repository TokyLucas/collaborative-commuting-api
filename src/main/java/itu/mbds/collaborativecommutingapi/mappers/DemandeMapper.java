package itu.mbds.collaborativecommutingapi.mappers;

import itu.mbds.collaborativecommutingapi.dtos.demande.DemandeRequestDTO;
import itu.mbds.collaborativecommutingapi.dtos.demande.DemandeResponseDTO;
import itu.mbds.collaborativecommutingapi.entities.Demande;
import org.springframework.stereotype.Component;

@Component
public class DemandeMapper {
    public Demande toEntity(DemandeRequestDTO dto) {
        return Demande.builder()
                .etudiantId(dto.getEtudiantId())
                .pointDepart(dto.getPointDepart())
                .departLatitude(dto.getDepartLatitude())
                .departLongitude(dto.getDepartLongitude())
                .pointArrivee(dto.getPointArrivee())
                .arriveeLongitude(dto.getArriveeLongitude())
                .arriveeLatitude(dto.getArriveeLatitude())
                .nbPlaces(dto.getNbPlaces())
                .tarif(dto.getTarif())
                .heureArriveeEstimee(dto.getHeureArriveeEstimee())
                .build();
    }

    public static Demande toEntity(DemandeResponseDTO dto) {
        return Demande.builder()
                .etudiantId(dto.getEtudiantId())
                .pointDepart(dto.getPointDepart())
                .departLatitude(dto.getDepartLatitude())
                .departLongitude(dto.getDepartLongitude())
                .pointArrivee(dto.getPointArrivee())
                .arriveeLongitude(dto.getArriveeLongitude())
                .arriveeLatitude(dto.getArriveeLatitude())
                .nbPlaces(dto.getNbPlaces())
                .tarif(dto.getTarif())
                .heureArriveeEstimee(dto.getHeureArriveeEstimee())
                .statut(dto.getStatut())
                .dateCreation(dto.getDateCreation())
                .build();
    }

    public DemandeResponseDTO toDto(Demande demande) {
        return DemandeResponseDTO.builder()
                .etudiantId(demande.getEtudiantId())
                .pointDepart(demande.getPointDepart())
                .departLatitude(demande.getDepartLatitude())
                .departLongitude(demande.getDepartLongitude())
                .pointArrivee(demande.getPointArrivee())
                .arriveeLongitude(demande.getArriveeLongitude())
                .arriveeLatitude(demande.getArriveeLatitude())
                .nbPlaces(demande.getNbPlaces())
                .tarif(demande.getTarif())
                .heureArriveeEstimee(demande.getHeureArriveeEstimee())
                .statut(demande.getStatut())
                .dateCreation(demande.getDateCreation())
                .build();
    }
}
