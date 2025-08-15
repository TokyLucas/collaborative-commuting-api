package itu.mbds.collaborativecommutingapi.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "trajet_conducteurs")
public class TrajetConducteur {
    @Id
    private String id;
    private String idConducteur;
    private String pointDepart;
    private Double latDepart;
    private Double lngDepart;
    private String pointArrivee;
    private Double latArrivee;
    private Double lngArrivee;
    private LocalDateTime heureDepartEstimee;
    private Integer placesDisponibles;
    private String description;
    private String statut;
    private LocalDateTime creeLe = LocalDateTime.now();
    private LocalDateTime misAJourLe = LocalDateTime.now();
    private Integer actif;
}
