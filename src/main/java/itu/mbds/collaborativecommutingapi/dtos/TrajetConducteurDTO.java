package itu.mbds.collaborativecommutingapi.dtos;
import com.fasterxml.jackson.annotation.JsonFormat;
import itu.mbds.collaborativecommutingapi.entities.Car;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class TrajetConducteurDTO {
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDesactivationDebut;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDesactivationFin;
}
