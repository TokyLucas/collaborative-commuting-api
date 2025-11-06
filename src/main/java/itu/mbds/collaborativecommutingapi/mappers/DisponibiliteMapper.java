package itu.mbds.collaborativecommutingapi.mappers;

import itu.mbds.collaborativecommutingapi.dtos.disponibilite.DisponibiliteDTO;
import itu.mbds.collaborativecommutingapi.dtos.disponibilite.DisponibiliteEventDTO;
import itu.mbds.collaborativecommutingapi.dtos.disponibilite.DisponibiliteRequestDTO;
import itu.mbds.collaborativecommutingapi.entities.Disponibilite;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component
public class DisponibiliteMapper {

    public Disponibilite toEntity(DisponibiliteRequestDTO dto) {
        if (dto == null) return null;
        return Disponibilite.builder()
                .conducteurId(new ObjectId(dto.getConducteurId()))
                .position(dto.getPosition())
                .statut(dto.getStatut())
                .build();
    }

    public DisponibiliteDTO toDTO(Disponibilite entity) {
        if (entity == null) return null;
        return DisponibiliteDTO.builder()
                .id(entity.getId())
                .conducteurId(entity.getConducteurId() != null ? entity.getConducteurId().toHexString() : null)
                .position(entity.getPosition())
                .statut(entity.getStatut())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public DisponibiliteEventDTO toEvent(Disponibilite entity) {
        if (entity == null) return null;
        return DisponibiliteEventDTO.builder()
                .id(entity.getId())
                .conducteurId(entity.getConducteurId() != null ? entity.getConducteurId().toHexString() : null)
                .longitude(entity.getPosition() != null ? entity.getPosition().getX() : 0.0)
                .latitude(entity.getPosition() != null ? entity.getPosition().getY() : 0.0)
                .statut(entity.getStatut() != null ? entity.getStatut().name() : null)
                .build();
    }
}
