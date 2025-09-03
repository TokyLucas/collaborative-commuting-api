package itu.mbds.collaborativecommutingapi.models;

import itu.mbds.collaborativecommutingapi.entities.Car;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    // Si la vue renvoie ISO string, garde String; si tu as converti en Date dans la vue, mets java.util.Date
    private String heureDepartEstimee;

    private Integer placesDisponibles;
    private String description;
    private String statut;
    private Integer actif;

    private String voitureId;       // id de la voiture référencée
    private Car car;
}
