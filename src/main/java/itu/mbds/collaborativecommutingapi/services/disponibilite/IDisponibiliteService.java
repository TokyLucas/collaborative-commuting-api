package itu.mbds.collaborativecommutingapi.services.disponibilite;

import itu.mbds.collaborativecommutingapi.dtos.disponibilite.DisponibiliteDTO;
import itu.mbds.collaborativecommutingapi.dtos.disponibilite.DisponibiliteRequestDTO;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;

import java.util.List;

public interface IDisponibiliteService {
    DisponibiliteDTO create(DisponibiliteRequestDTO dto);
    DisponibiliteDTO updatePosition(String conducteurId, DisponibiliteRequestDTO dto);
    DisponibiliteDTO updateStatut(String conducteurId, itu.mbds.collaborativecommutingapi.enums.DisponibiliteStatut statut);
    List<DisponibiliteDTO> findNearby(Point location, Distance radius);
}
