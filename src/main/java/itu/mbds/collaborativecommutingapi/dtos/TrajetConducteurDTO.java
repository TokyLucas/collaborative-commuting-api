package itu.mbds.collaborativecommutingapi.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TrajetConducteurDTO {
    private String id;
    private String idConducteur;
    private String pointDepart;
    private double latDepart;
    private double lngDepart;
    private String pointArrivee;
    private double latArrivee;
    private double lngArrivee;
    private LocalDateTime heureDepartEstimee;
    private int placesDisponibles;
    private String description;
    private String statut;
}
