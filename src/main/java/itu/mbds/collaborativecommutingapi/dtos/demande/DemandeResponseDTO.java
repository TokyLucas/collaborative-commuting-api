package itu.mbds.collaborativecommutingapi.dtos.demande;

import itu.mbds.collaborativecommutingapi.enums.Status;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class DemandeResponseDTO {
    private String id;
    private String etudiantId;
    private Double departLatitude;
    private Double departLongitude;
    private Double arriveeLatitude;
    private Double arriveeLongitude;
    private Status statut;
    private Date dateCreation;
}
