package itu.mbds.collaborativecommutingapi.dtos.demande;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class DemandeRequestDTO {
    @NotNull
    private Double departLatitude;
    @NotNull
    private Double departLongitude;
    @NotNull
    private Double arriveeLatitude;
    @NotNull
    private Double arriveeLongitude;
}
