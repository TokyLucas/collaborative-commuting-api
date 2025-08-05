package itu.mbds.collaborativecommutingapi.entities;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "disponibilites")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Disponibilite {
    @Id
    private String id;
    @NotNull
    private String conducteurId;
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint position;
    @NotNull
    private itu.mbds.collaborativecommutingapi.enums.DisponibiliteStatut statut;
    @LastModifiedDate
    private Date updatedAt;
}
