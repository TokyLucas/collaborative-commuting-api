package itu.mbds.collaborativecommutingapi.dtos.demande;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class DemandeRequestDTO {

    @NotNull
    private String id;

    @NotNull
    private String etudiantId;

    @NotNull
    private String pointDepart;

    @NotNull
    private Double departLatitude;

    @NotNull
    private Double departLongitude;

    @NotNull
    private String pointArrivee;

    @NotNull
    private Double arriveeLatitude;

    @NotNull
    private Double arriveeLongitude;

    @NotNull
    private LocalDateTime heureDepartEstimee;

    @NotNull
    private Disponibilite nbDisponibilite;

    @NotNull
    private Status statut = Status.EN_ATTENTE;

    @CreatedDate
    private Date dateCreation;

    @LastModifiedDate
    private Date dateMiseAJour;
}
