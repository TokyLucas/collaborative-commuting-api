package itu.mbds.collaborativecommutingapi.models;

import itu.mbds.collaborativecommutingapi.entities.Car;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
    private Integer placesDispoJournalier;
    private String description;
    private String statut;
    private LocalDateTime creeLe = LocalDateTime.now();
    private LocalDateTime misAJourLe = LocalDateTime.now();
    private Integer actif;
    private String voitureId;
    private List<Integer> jours;
    private LocalDate dateDesactivationDebut;
    private LocalDate dateDesactivationFin;
}
