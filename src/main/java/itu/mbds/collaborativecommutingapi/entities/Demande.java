package itu.mbds.collaborativecommutingapi.entities;

import itu.mbds.collaborativecommutingapi.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "demandes")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Demande {

    @Id
    private String id;

    @NotBlank
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
    private int nbPlaces;

    @NotNull
    private Double tarif;

    @NotNull
    private LocalDateTime heureDepartEstimee;

    @NotNull
    private Status statut = Status.EN_ATTENTE;

    @CreatedDate
    private Date dateCreation;

    @LastModifiedDate
    private Date dateMiseAJour;
}
