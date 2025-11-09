package itu.mbds.collaborativecommutingapi.services.demande;

import itu.mbds.collaborativecommutingapi.dtos.demande.DemandeRequestDTO;
import itu.mbds.collaborativecommutingapi.dtos.demande.DemandeResponseDTO;
import itu.mbds.collaborativecommutingapi.enums.Status;
import itu.mbds.collaborativecommutingapi.mappers.DemandeMapper;
import itu.mbds.collaborativecommutingapi.entities.Demande;
import itu.mbds.collaborativecommutingapi.models.TrajetConducteur;
import itu.mbds.collaborativecommutingapi.repositories.DemandeRepository;
import itu.mbds.collaborativecommutingapi.repositories.TrajetConducteurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DemandeServiceImpl implements IDemandeService {
    private final DemandeRepository demandeRepository;
    private final DemandeMapper demandeMapper;
    private final TrajetConducteurRepository trajetConducteurRepository;

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

    @Override
public List<DemandeResponseDTO> getDemandesByPassagerId(String passagerId) {
        List<Demande> demandes = demandeRepository.findByEtudiantId(passagerId);
        return demandes.stream()
                .map(demandeMapper::toDto)
                .toList();
    }

    public DemandeResponseDTO getAcceptedLinked(String userId) {

        Demande passengerDemande = demandeRepository
                .findByEtudiantIdAndStatut(userId, Status.ACCEPTEE)
                .orElse(null);

        if (passengerDemande != null) {
            return demandeMapper.toDto(passengerDemande);
        }

        List<TrajetConducteur> trajets = trajetConducteurRepository
                .findByIdConducteur(userId);

        if (trajets == null || trajets.isEmpty()) {
            return null;
        }

        for (TrajetConducteur trajet : trajets) {

            List<Demande> demandesLiees = demandeRepository
                    .findByTrajetIdAndStatut(trajet.getId(), Status.ACCEPTEE);

            if (demandesLiees != null && !demandesLiees.isEmpty()) {
                // on renvoie la première demande acceptée trouvée
                return demandeMapper.toDto(demandesLiees.get(0));
            }
        }

        return null;
    }

}
