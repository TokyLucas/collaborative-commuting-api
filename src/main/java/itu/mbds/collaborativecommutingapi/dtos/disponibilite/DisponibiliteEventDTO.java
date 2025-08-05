package itu.mbds.collaborativecommutingapi.dtos.disponibilite;

import lombok.*;

@Data
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class DisponibiliteEventDTO {
    private String id;
    private String conducteurId;
    private double longitude;
    private double latitude;
    private String statut;
}
