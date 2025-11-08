package itu.mbds.collaborativecommutingapi.dtos.demande;

import itu.mbds.collaborativecommutingapi.entities.Disponibilite;
import itu.mbds.collaborativecommutingapi.enums.Status;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
public class DemandeResponseDTO {
    private String etudiantId;
    private String pointDepart;
    private Double departLatitude;
    private Double departLongitude;
    private String pointArrivee;
    private Double arriveeLatitude;
    private Double arriveeLongitude;
    private int nbPlaces;
    private Double tarif;
    private LocalDateTime heureArriveeEstimee;
    private Status statut;
    private Date dateCreation;
    private String trajetId;
    private String conducteurId;
}
