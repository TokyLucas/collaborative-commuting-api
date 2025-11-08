package itu.mbds.collaborativecommutingapi.services.demande;

import itu.mbds.collaborativecommutingapi.dtos.demande.DemandeRequestDTO;
import itu.mbds.collaborativecommutingapi.dtos.demande.DemandeResponseDTO;

import java.util.List;

public interface IDemandeService {
    DemandeResponseDTO create(DemandeRequestDTO dto);

    DemandeResponseDTO getById(String id);

    List<DemandeResponseDTO> getAll();

    void delete(String id);

    List<DemandeResponseDTO> getDemandesByPassagerId(String passagerId);
    DemandeResponseDTO getAcceptedDemande(String etudiantId);

}
