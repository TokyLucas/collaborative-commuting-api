package itu.mbds.collaborativecommutingapi.dtos.disponibilite;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

@Data
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class DisponibiliteRequestDTO {
    @NotNull
    private String conducteurId;
    @NotNull
    private GeoJsonPoint position;
    @NotNull
    private itu.mbds.collaborativecommutingapi.enums.DisponibiliteStatut statut;
}
