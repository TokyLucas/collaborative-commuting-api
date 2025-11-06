package itu.mbds.collaborativecommutingapi.mappers;

import itu.mbds.collaborativecommutingapi.dtos.TrajetConducteurDTO;
import itu.mbds.collaborativecommutingapi.models.TrajetConducteur;

public class TrajetConducteurMapper {
    public static TrajetConducteur toEntity(TrajetConducteurDTO dto) {
        TrajetConducteur t = new TrajetConducteur();
        t.setId(dto.getId());
        t.setIdConducteur(dto.getIdConducteur());
        t.setPointDepart(dto.getPointDepart());
        t.setLatDepart(dto.getLatDepart());
        t.setLngDepart(dto.getLngDepart());
        t.setPointArrivee(dto.getPointArrivee());
        t.setLatArrivee(dto.getLatArrivee());
        t.setLngArrivee(dto.getLngArrivee());
        t.setHeureDepartEstimee(dto.getHeureDepartEstimee());
        t.setPlacesDisponibles(dto.getPlacesDisponibles());
        t.setDescription(dto.getDescription());
        t.setStatut(dto.getStatut());
        t.setActif(dto.getActif());
        t.setVoitureId(dto.getVoitureId());
        t.setJours(dto.getJours());
        return t;
    }

    public static TrajetConducteurDTO toDto(TrajetConducteur t) {
        TrajetConducteurDTO dto = new TrajetConducteurDTO();
        dto.setId(t.getId());
        dto.setIdConducteur(t.getIdConducteur());
        dto.setPointDepart(t.getPointDepart());
        dto.setLatDepart(t.getLatDepart());
        dto.setLngDepart(t.getLngDepart());
        dto.setPointArrivee(t.getPointArrivee());
        dto.setLatArrivee(t.getLatArrivee());
        dto.setLngArrivee(t.getLngArrivee());
        dto.setHeureDepartEstimee(t.getHeureDepartEstimee());
        dto.setPlacesDisponibles(t.getPlacesDisponibles());
        dto.setDescription(t.getDescription());
        dto.setStatut(t.getStatut());
        dto.setActif(t.getActif());
        dto.setVoitureId(t.getVoitureId());
        dto.setJours(t.getJours());
        return dto;
    }

}
