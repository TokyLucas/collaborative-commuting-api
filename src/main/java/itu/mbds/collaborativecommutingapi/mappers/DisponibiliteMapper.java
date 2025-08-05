package itu.mbds.collaborativecommutingapi.mappers;

import itu.mbds.collaborativecommutingapi.dtos.disponibilite.DisponibiliteDTO;
import itu.mbds.collaborativecommutingapi.dtos.disponibilite.DisponibiliteEventDTO;
import itu.mbds.collaborativecommutingapi.dtos.disponibilite.DisponibiliteRequestDTO;
import itu.mbds.collaborativecommutingapi.entities.Disponibilite;
import org.springframework.stereotype.Component;

@Component
public class DisponibiliteMapper {
    public Disponibilite toEntity(DisponibiliteRequestDTO dto) {
        return Disponibilite.builder()
                .conducteurId(dto.getConducteurId())
                .position(dto.getPosition())
                .statut(dto.getStatut())
                .build();
    }

    public DisponibiliteDTO toDTO(Disponibilite entity) {
        return DisponibiliteDTO.builder()
                .id(entity.getId())
                .conducteurId(entity.getConducteurId())
                .position(entity.getPosition())
                .statut(entity.getStatut())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public DisponibiliteEventDTO toEvent(Disponibilite entity) {
        return DisponibiliteEventDTO.builder()
                .id(entity.getId())
                .conducteurId(entity.getConducteurId())
                .longitude(entity.getPosition().getX())
                .latitude(entity.getPosition().getY())
                .statut(entity.getStatut().name())
                .build();
    }
}
