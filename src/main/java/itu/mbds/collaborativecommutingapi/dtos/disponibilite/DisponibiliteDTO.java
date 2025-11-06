package itu.mbds.collaborativecommutingapi.dtos.disponibilite;

import lombok.*;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.time.Instant;
import java.util.Date;

@Data
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class DisponibiliteDTO {
    private String id;
    private String conducteurId;
    private GeoJsonPoint position;
    private itu.mbds.collaborativecommutingapi.enums.DisponibiliteStatut statut;
    private Instant updatedAt;
}
