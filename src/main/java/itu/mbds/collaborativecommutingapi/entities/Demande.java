package itu.mbds.collaborativecommutingapi.entities;

import itu.mbds.collaborativecommutingapi.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "demandes")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Demande {

    @Id
    private String id;

    @NotBlank
    private String etudiantId;

    @NotNull
    private Double departLatitude;

    @NotNull
    private Double departLongitude;

    @NotNull
    private Double arriveeLatitude;

    @NotNull
    private Double arriveeLongitude;

    private Status statut = Status.EN_ATTENTE; // EN_ATTENTE, ACCEPTEE, TERMINEE, ANNULEE

    @CreatedDate
    private Date dateCreation;

    @LastModifiedDate
    private Date dateMiseAJour;
}
