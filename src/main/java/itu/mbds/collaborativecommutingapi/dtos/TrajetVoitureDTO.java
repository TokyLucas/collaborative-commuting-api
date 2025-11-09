package itu.mbds.collaborativecommutingapi.dtos;

import itu.mbds.collaborativecommutingapi.models.TrajetVoitureView;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
public class TrajetVoitureDTO {
    String id;
    String pointDepart;
    String pointArrivee;
    String heureDepartEstimee;
    Integer placesDisponibles;
    String statut;

    String carBrand;
    String carModel;
    String carColor;
    Integer carNbPlaces;

    // Nouveaux champs
    List<Integer> jours;
    LocalDateTime dateDesactivationDebut;
    LocalDateTime dateDesactivationFin;

    public static TrajetVoitureDTO from(TrajetVoitureView v) {
        return new TrajetVoitureDTO(
                v.getId(),
                v.getPointDepart(),
                v.getPointArrivee(),
                v.getHeureDepartEstimee(),
                v.getPlacesDisponibles(),
                v.getStatut(),
                v.getCar() != null ? v.getCar().getBrand() : null,
                v.getCar() != null ? v.getCar().getModel() : null,
                v.getCar() != null ? v.getCar().getColor() : null,
                v.getCar() != null ? v.getCar().getNbPlaces() : null,
                v.getJours(),
                v.getDateDesactivationDebut(),
                v.getDateDesactivationFin()
        );
    }
}
