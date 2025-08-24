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
        return t;
    }

    public static TrajetConducteurDTO toDTO(TrajetConducteur entity) {
        TrajetConducteurDTO dto = new TrajetConducteurDTO();
        dto.setId(entity.getId());
        dto.setIdConducteur(entity.getIdConducteur());
        dto.setPointDepart(entity.getPointDepart());
        dto.setLatDepart(entity.getLatDepart());
        dto.setLngDepart(entity.getLngDepart());
        dto.setPointArrivee(entity.getPointArrivee());
        dto.setLatArrivee(entity.getLatArrivee());
        dto.setLngArrivee(entity.getLngArrivee());
        dto.setHeureDepartEstimee(entity.getHeureDepartEstimee());
        dto.setPlacesDisponibles(entity.getPlacesDisponibles());
        dto.setDescription(entity.getDescription());
        dto.setStatut(entity.getStatut());
        return dto;
    }
}
