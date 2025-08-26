package itu.mbds.collaborativecommutingapi.services.match;

import itu.mbds.collaborativecommutingapi.dtos.TrajetConducteurDTO;
import itu.mbds.collaborativecommutingapi.dtos.demande.DemandeResponseDTO;
import itu.mbds.collaborativecommutingapi.entities.Demande;
import itu.mbds.collaborativecommutingapi.models.TrajetConducteur;

import java.util.List;

public interface IMatchingService {
    List<TrajetConducteurDTO> matchConducteurs(DemandeResponseDTO demandeDTO);
}
