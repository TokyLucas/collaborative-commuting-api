package itu.mbds.collaborativecommutingapi.dtos;
import itu.mbds.collaborativecommutingapi.entities.Car;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class TrajetConducteurDTO {
    private String id;
    private String idConducteur;
    private String pointDepart;
    private Double latDepart;
    private Double lngDepart;
    private String pointArrivee;
    private Double latArrivee;
    private Double lngArrivee;
    private LocalDateTime heureDepartEstimee;
    private Integer placesDisponibles;
    private String description;
    private String statut;
    private Integer actif;
    private String voitureId;
    private List<Integer> jours ;
}
