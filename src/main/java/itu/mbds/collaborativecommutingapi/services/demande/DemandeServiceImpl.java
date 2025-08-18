package itu.mbds.collaborativecommutingapi.services.demande;

import itu.mbds.collaborativecommutingapi.dtos.demande.DemandeRequestDTO;
import itu.mbds.collaborativecommutingapi.dtos.demande.DemandeResponseDTO;
import itu.mbds.collaborativecommutingapi.enums.Status;
import itu.mbds.collaborativecommutingapi.mappers.DemandeMapper;
import itu.mbds.collaborativecommutingapi.entities.Demande;
import itu.mbds.collaborativecommutingapi.repositories.DemandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DemandeServiceImpl implements IDemandeService {
    private final DemandeRepository demandeRepository;
    private final DemandeMapper demandeMapper;

    @Override
    public DemandeResponseDTO create(DemandeRequestDTO dto) {
        Demande demande = demandeMapper.toEntity(dto);
        demande.setStatut(Status.EN_ATTENTE);
        demande.setDateCreation(new Date());
        Demande saved = demandeRepository.save(demande);
        return demandeMapper.toDto(saved);
    }

    @Override
    public DemandeResponseDTO getById(String id) {
        Demande demande = demandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Demande non trouvée"));
        return demandeMapper.toDto(demande);
    }

    @Override
    public List<DemandeResponseDTO> getAll() {
        return demandeRepository.findAll()
                .stream()
                .map(demandeMapper::toDto)
                .toList();
    }

    @Override
    public void delete(String id) {
        if (!demandeRepository.existsById(id)) {
            throw new RuntimeException("Demande introuvable pour suppression");
        }
        demandeRepository.deleteById(id);
    }

    /*@Override
    public List<MatchResponseDTO> matchDemandes(String demandeId) {
        // 👉 Ici tu appelles la logique de matching (conducteurs proches + trajets compatibles)
        // Pour l'instant je mets un stub
        return List.of();
    }*/
}
