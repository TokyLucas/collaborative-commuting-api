package itu.mbds.collaborativecommutingapi.services.trajetConducteur;

import itu.mbds.collaborativecommutingapi.dtos.TrajetConducteurDTO;
import itu.mbds.collaborativecommutingapi.models.TrajetConducteur;

import java.util.List;

public interface ITrajetConducteurService {

        TrajetConducteur create(TrajetConducteurDTO dto);
        List<TrajetConducteur> getAll();
        TrajetConducteur getById(String id);
        void delete(String id);
        TrajetConducteur update(String id, TrajetConducteurDTO trajet);
        List<TrajetConducteurDTO> getByIdConducteur(String conducteurId);
        List<TrajetConducteur> getByStatut(String statut);
}
