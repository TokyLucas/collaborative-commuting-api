package itu.mbds.collaborativecommutingapi.services.demande;

import itu.mbds.collaborativecommutingapi.dtos.demande.DemandeRequestDTO;
import itu.mbds.collaborativecommutingapi.dtos.demande.DemandeResponseDTO;
import itu.mbds.collaborativecommutingapi.entities.Demande;
import itu.mbds.collaborativecommutingapi.repositories.DemandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DemandeServiceImpl {
    private final DemandeRepository demandeRepository;

    public DemandeResponseDTO create(DemandeRequestDTO dto) {
        Demande demande = Demande.builder()
                .departLatitude(dto.getDepartLatitude())
                .departLongitude(dto.getDepartLongitude())
                .arriveeLatitude(dto.getArriveeLatitude())
                .arriveeLongitude(dto.getArriveeLongitude())
                .build();

        Demande saved = demandeRepository.save(demande);

        return DemandeResponseDTO.builder()
                .id(saved.getId())
                .etudiantId(saved.getEtudiantId())
                .departLatitude(saved.getDepartLatitude())
                .departLongitude(saved.getDepartLongitude())
                .arriveeLatitude(saved.getArriveeLatitude())
                .arriveeLongitude(saved.getArriveeLongitude())
                .statut(saved.getStatut())
                .dateCreation(saved.getDateCreation())
                .build();
    }

    public List<Demande> findAll() {
        return demandeRepository.findAll();
    }
}
