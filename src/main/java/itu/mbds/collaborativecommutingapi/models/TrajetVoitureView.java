package itu.mbds.collaborativecommutingapi.models;

import itu.mbds.collaborativecommutingapi.entities.Car;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "trajets_voitures")
public class TrajetVoitureView {

    @Id
    private String id;

    private String idConducteur;
    private String pointDepart;
    private Double latDepart;
    private Double lngDepart;
    private String pointArrivee;
    private Double latArrivee;
    private Double lngArrivee;

    private String heureDepartEstimee;

    private Integer placesDisponibles;
    private String description;
    private String statut;
    private Integer actif;

    private String voitureId;
    private Car car;

    // Nouveaux champs de la vue
    private List<Integer> jours;
    private LocalDateTime dateDesactivationDebut;
    private LocalDateTime dateDesactivationFin;
}
