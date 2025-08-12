package itu.mbds.collaborativecommutingapi.services.demande;

import itu.mbds.collaborativecommutingapi.dtos.demande.DemandeRequestDTO;
import itu.mbds.collaborativecommutingapi.dtos.demande.DemandeResponseDTO;

public interface IDemandeService {
    DemandeResponseDTO create(DemandeRequestDTO dto);

}
